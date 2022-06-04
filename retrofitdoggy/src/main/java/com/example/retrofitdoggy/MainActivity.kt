package com.example.retrofitdoggy

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import com.example.retrofitdoggy.api.ApiRequest
import com.example.retrofitdoggy.api.BASE_URL
import com.example.retrofitdoggy.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        backgoundAnimation()
        makeApiRequest()
        with(binding) {
            setContentView(binding.root)
            floatingActionButton.setOnClickListener {
                floatingActionButton.animate().apply {
                    rotationBy(360f)
                    duration = 1000
                }.start()
                makeApiRequest()
                ivRandomDog.visibility = View.GONE
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun makeApiRequest() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)
            Log.i("!!!"," !!!!!!!!!!!!!!!1")
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getRandomDog()
                Log.d("Main", "Seize: ${response.fileSizeBytes}")

                if (response.fileSizeBytes < 400_000) {
                    withContext(Dispatchers.Main) {
                        Glide.with(applicationContext).load(response.url).into(binding.ivRandomDog)
                        binding.ivRandomDog.visibility = View.VISIBLE
                    }
                } else {
                    makeApiRequest()
                }
            } catch (e: Exception) {
                Log.e("Main", e.message.toString())
            }
        }
    }

    private fun backgoundAnimation() {
        binding.apply {
            val animationDrawable: AnimationDrawable = rlLayout.background as AnimationDrawable
            animationDrawable.apply {
                setEnterFadeDuration(1000)
                setExitFadeDuration(3000)
                start()
            }

        }
    }
}