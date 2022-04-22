package com.example.logsandtoasts

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.logsandtoasts.databinding.ActivityMainBinding

class MainActivity : Activity(), View.OnClickListener {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    /** Called when the activity is first created.  */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.i("???", "/** Called when the activity is first created.  */")
    }

    override fun onClick(v: View) {
        // по id определяем кнопку, вызвавшую этот обработчик
        Log.i("???", "// по id определяем кнопку, вызвавшую этот обработчик")
        with(binding) {
            when (v.getId()) {
                R.id.btnOk ->       // кнопка ОК
                    tvOut.text = "Нажата кнопка ОК"
                R.id.btnCancel ->       // кнопка Cancel
                    tvOut.text = "Нажата кнопка Cancel"
            }
            Log.i("???", "// по id определяем кнопку, вызвавшую этот обработчик")
            when (v.getId()) {
                R.id.btnOk ->       // кнопка ОК
                    Toast.makeText(this@MainActivity, "\"Нажата кнопка ОК\"", Toast.LENGTH_LONG)
                        .show()

                R.id.btnCancel ->       // кнопка Cancel
                    Toast.makeText(this@MainActivity, "\"Нажата кнопка Cancel\"", Toast.LENGTH_LONG)
                        .show()
            }
        }
    }
}
