package com.example.fregmentsyoutube

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        val buttonFragment1 = findViewById<Button>(R.id.fragment1_button1)
        val buttonFragment2 = findViewById<Button>(R.id.fragment2_button1)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment1, firstFragment)
            addToBackStack("FirstFragmentBackStack")
            commit()
        }

        buttonFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment1, firstFragment)
                addToBackStack("FirstFragmentBackStack")
                commit()
            }
        }

        buttonFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment1, secondFragment)
                addToBackStack("SecondFragmentBackStack")
                commit()
            }
        }
    }
}