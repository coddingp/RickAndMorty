package com.example.weight

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView


class MainActivity : Activity() {
    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1 = findViewById<View>(R.id.button1) as Button
        button1.isEnabled = false

        val checkBox = findViewById<View>(R.id.checkBox) as CheckBox
        checkBox.isChecked = true
    }
}