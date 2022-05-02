package com.example.koinmodules.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.koinmodules.R
import org.koin.android.ext.android.get
import org.koin.core.context.GlobalContext.get

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val student:Student = get<Student>()
        student.beSmart()
    }

}