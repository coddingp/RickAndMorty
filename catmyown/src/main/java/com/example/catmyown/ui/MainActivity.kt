package com.example.catmyown.ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.catmyown.api.CatApi
import com.example.catmyown.api.CatRequest
import com.example.catmyown.databinding.ActivityMainBinding
import com.example.catmyown.model.CatsClass
import java.net.URL

private const val API_KEY = "78b6dd25-d96b-438d-85e3-e7dc21481d75"

class MainActivity : AppCompatActivity(), MainContract {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    private val api: CatApi = CatRequest.getRetrofit().create(CatApi::class.java)
    private val presenter: MainPresenter = MainPresenter(api)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.i("!Main", "Works")
//        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
//        backgroundAnimation()

        presenter.attach(this@MainActivity)
        presenter.getCatsData(API_KEY)

        with(binding) {
            setContentView(binding.root)
            imageButton.setOnClickListener {
                imageButton.animate().apply {
                    rotationBy(360f)
                    duration = 1000
                    presenter.getCatsData(API_KEY)
                }.start()
                imageView.visibility = View.GONE
            }
        }


    }

    private fun backgroundAnimation() {
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

    override fun failure(message: String) {
        error(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach(this)
    }

    override fun showCatsData(data: CatsClass) = with(binding) {
        setContentView(binding.root)
    }

    fun onClick(view: View) {
        binding.apply {
            setContentView(binding.root)
            presenter.getCatsData(API_KEY)
        }
    }

}