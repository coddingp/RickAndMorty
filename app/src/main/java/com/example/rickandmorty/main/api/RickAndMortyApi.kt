package com.example.rickandmorty.main.api

import com.example.rickandmorty.main.models.character.CharacterData
//import com.company.rickmorty.main.models.episode.EpisodeData
//import com.company.rickmorty.main.models.location.LocationData
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    fun getAllCharacters(): Call<CharacterData>
}