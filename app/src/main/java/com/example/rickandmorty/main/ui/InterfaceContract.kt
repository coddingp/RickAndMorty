package com.example.rickandmorty.main.ui

import com.example.rickandmorty.main.ui.models.WholeData

interface InterfaceContract {
    fun showRickAndMortyData(data: WholeData)
    fun onDataFailure(message: String)
}