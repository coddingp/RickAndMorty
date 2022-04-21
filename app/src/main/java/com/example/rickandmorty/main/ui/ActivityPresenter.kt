package com.example.rickandmorty.main.ui

import com.example.rickandmorty.main.api.Api
import com.example.rickandmorty.main.ui.models.WholeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityPresenter(private val api: Api) {
    private var interfaceContract: InterfaceContract? = null
    fun attach(view: InterfaceContract) {
        interfaceContract = view
    }

    fun detach(view: InterfaceContract) {
        interfaceContract = null
    }

    fun getRickAndMortyData() {
        api.getRickAndMortyData().enqueue(object : Callback<WholeData>{
            override fun onResponse(call: Call<WholeData>, response: Response<WholeData>) {

            }

            override fun onFailure(call: Call<WholeData>, t: Throwable) {
                t.message?.let { interfaceContract?.onDataFailure(it)}
            }
        })

    }

}