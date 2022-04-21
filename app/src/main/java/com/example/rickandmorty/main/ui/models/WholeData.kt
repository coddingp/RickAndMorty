package com.example.rickandmorty.main.ui.models

import com.google.gson.annotations.SerializedName
data class WholeData(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Results>
)
