package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragments.fragments.ButtonFragment
import com.example.fragments.fragments.CheckBoxFragment
import com.example.fragments.fragments.ImageFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonFragment = ButtonFragment()
        val imageFragment = ImageFragment()
        val checkBoxFragment = CheckBoxFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flButtons, buttonFragment)
            addToBackStack("ButtonFragmentBackStack")
            commit()
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flCheckBox, checkBoxFragment)
            addToBackStack("CheckBoxFragmentBackStack")
            commit()
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flImage, imageFragment)
            addToBackStack("ImageFragmentBackStack")
            commit()
        }
    }
}