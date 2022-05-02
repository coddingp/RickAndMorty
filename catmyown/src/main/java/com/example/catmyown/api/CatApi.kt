package com.example.catmyown.api

import com.example.catmyown.model.CatsClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("v1/images/search")
    fun getImagesData(
        @Query("api_key") apiKey: String
    ): Call<CatsClass>
}