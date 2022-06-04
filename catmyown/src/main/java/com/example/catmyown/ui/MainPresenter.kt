package com.example.catmyown.ui

import android.util.Log
import com.example.catmyown.api.CatApi
import com.example.catmyown.model.CatsClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val API_KEY = "78b6dd25-d96b-438d-85e3-e7dc21481d75"

class MainPresenter(private val catApi: CatApi) {
    private var mainContract: MainContract? = null

    fun attach(view: MainContract) {
        mainContract = view
    }

    fun detach(view: MainContract) {
        mainContract = null
    }

    fun getCatsData(apiKey: String) {
        catApi.getImagesData(API_KEY)
            .enqueue(object : Callback<CatsClass> {
                override fun onResponse(call: Call<CatsClass>, response: Response<CatsClass>) {

                    if (response.isSuccessful && response.body() != null) {
                        Log.i("!onResponse", "response")
                        val data = response.body()!!
                        mainContract?.showCatsData(data)
                    }
                }

                override fun onFailure(call: Call<CatsClass>, t: Throwable) {
                    t.message?.let { mainContract?.failure(it) }
                }

            })
    }
}