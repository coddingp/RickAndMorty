package com.example.rickandmorty.main.api

import com.example.rickandmorty.main.ui.models.WholeData
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/character")
    fun getRickAndMortyData(): Call<WholeData>
}