package com.example.catmyown.api

import retrofit2.http.GET

const val BASE_URL = "https://thecatapi.com/"

interface CatRequest {
    @GET("v1/images/search?breed_ids=beng&include_breeds=true")
    suspend fun getRandomCat(): CatApi
}