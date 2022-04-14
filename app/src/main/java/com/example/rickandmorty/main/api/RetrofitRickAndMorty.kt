package com.example.rickandmorty.main.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://rickandmortyapi.com/api/"

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}
    //1. project structure
    //2. get data from api(log Timber)  UserIntercepter //As a result you should get heroes
    //3. reading recyclerView + Adapter + viewHolder
    //read about glide
    //get data from site
    //recyclerview android look for methods
    //viewHolder
    //ListView
