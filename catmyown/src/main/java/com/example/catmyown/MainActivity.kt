package com.example.catmyown

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import com.bumptech.glide.Glide
import com.example.catmyown.api.BASE_URL
import com.example.catmyown.api.CatRequest
import com.example.catmyown.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_KEY = "78b6dd25-d96b-438d-85e3-e7dc21481d75"

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.i("!Main", "Works")
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        backgoundAnimation()
        makeApiRequest()
        with(binding) {
            imageButton.setOnClickListener {
                imageButton.animate().apply {
                    rotationBy(360f)
                    duration = 1000
                }.start()
                makeApiRequest()
                imageView.visibility = View.VISIBLE
                setContentView(binding.root)
            }
        }
    }

    private fun backgoundAnimation() {
        setContentView(binding.root)
        binding.apply {
            val animationDrawable: AnimationDrawable =
                imageButton.background as AnimationDrawable
            animationDrawable.apply {
                setEnterFadeDuration(1000)
                setExitFadeDuration(3000)
                start()
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun makeApiRequest() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatRequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getRandomCat()
                Log.d("Main", "Seize: ${response.fileSizeBytes}")

                if (response.fileSizeBytes < 400_000) {
                    withContext(Dispatchers.Main) {
                        setContentView(binding.root)
                        Glide.with(applicationContext).load(response.url).into(binding.imageView)
                        binding.imageView.visibility = View.VISIBLE
                    }
                } else {
                    makeApiRequest()
                }
            } catch (e: Exception) {
                Log.e("Main", e.message.toString())
            }
        }

    }

}