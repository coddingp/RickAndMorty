package com.example.p17dynamiclayout.root

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.p17dynamiclayout.R
import com.example.p17dynamiclayout.databinding.ActivityRootBinding

class RootActivity : AppCompatActivity(), View.OnClickListener {
    var llMain: LinearLayout? = null
    var rgGravity: RadioGroup? = null
    var etName: EditText? = null
    var btnCreate: Button? = null
    var btnClear: Button? = null
    var wrapContent: Int = LinearLayout.LayoutParams.WRAP_CONTENT

    private val binding: ActivityRootBinding by lazy {
        ActivityRootBinding.inflate(layoutInflater)
    }

    /** Called when the activity is first created.  */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        llMain = findViewById<LinearLayout>(R.id.llMain)
        rgGravity = findViewById<RadioGroup>(R.id.gravityRadioGroup)
        etName = findViewById<EditText>(R.id.nameEditText)
        btnCreate = findViewById<Button>(R.id.createButton)
        btnCreate?.setOnClickListener(this)
        btnClear = findViewById<Button>(R.id.clearButton)
        btnClear?.setOnClickListener(this)
    }

    @SuppressLint("RtlHardcoded")
    override fun onClick(v: View) {
        when (v.id) {
            R.id.createButton -> {
                // Создание LayoutParams c шириной и высотой по содержимому
                val lParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                    wrapContent, wrapContent
                )
                // переменная для хранения значения выравнивания
                // по умолчанию пусть будет LEFT
                var btnGravity: Int = Gravity.LEFT
                when (rgGravity?.checkedRadioButtonId) {
                    R.id.leftRadioButton -> btnGravity = Gravity.LEFT
                    R.id.centerRadioButton -> btnGravity = Gravity.CENTER_HORIZONTAL
                    R.id.rightRadioButton -> btnGravity = Gravity.RIGHT
                }
                // переносим полученное значение выравнивания в LayoutParams
                lParams.gravity = btnGravity

                // создаем Button, пишем текст и добавляем в LinearLayout
                val btnNew = Button(this)
                btnNew.text = etName?.text.toString()
                llMain?.addView(btnNew, lParams)
            }
            R.id.clearButton -> {
                llMain?.removeAllViews()
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show()
            }
        }
    }
}