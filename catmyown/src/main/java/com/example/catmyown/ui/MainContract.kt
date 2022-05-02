package com.example.catmyown.ui

import com.example.catmyown.model.CatsClass
import com.example.catmyown.model.CatsData

interface MainContract {
    fun failure(message: String)
    fun showCatsData(data: CatsClass)
}