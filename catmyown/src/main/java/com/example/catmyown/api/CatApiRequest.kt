package com.example.catmyown.api

import android.provider.ContactsContract
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiRequest {

    @GET("v1/images")
    fun getWeatherData(
        @Query("images") Image: ContactsContract.CommonDataKinds.Photo,
        @Query("appid") appId: String,
        @Query("units") units: String,
        @Query("lang") lang: String
    )
}