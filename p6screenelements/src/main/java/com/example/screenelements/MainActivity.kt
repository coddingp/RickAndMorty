package com.example.screenelements

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)

        val okButton = findViewById<Button>(R.id.ok_button)

        val cancelButton = findViewById<Button>(R.id.cancel_button)

        textView.text = "Send money"

        okButton.setOnClickListener {
            textView.text = "money were sent"
        }
        cancelButton.setOnClickListener {
            textView.text = "money were not sent"
        }

        textView.setOnClickListener {
            if (textView.text != "Send money") {
                textView.text = "Send money"
            }
        }
    }
}