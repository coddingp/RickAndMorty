package com.example.p18changelayout

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar
import com.example.p18changelayout.databinding.ActivityRootBinding

class RootActivity : Activity(), SeekBar.OnSeekBarChangeListener {
    var sbWeight: SeekBar? = null
    var btn1: Button? = null
    var btn2: Button? = null
    var lParams1: LinearLayout.LayoutParams? = null
    var lParams2: LinearLayout.LayoutParams? = null

    private val binding: ActivityRootBinding by lazy {
        ActivityRootBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding){sbWeight.progress=60}
        sbWeight = findViewById<SeekBar>(R.id.sbWeight)
        sbWeight?.setOnSeekBarChangeListener(this)
        btn1 = findViewById<Button>(R.id.btn1)
        btn2 = findViewById<Button>(R.id.btn2)
        lParams1 = btn1?.layoutParams as LinearLayout.LayoutParams
        lParams2 = btn2?.layoutParams as LinearLayout.LayoutParams
    }

    override fun onProgressChanged(
        seekBar: SeekBar, progress: Int,
        fromUser: Boolean
    ) {
        val rightValue: Int = seekBar.getMax() - progress
        // настраиваем вес
        lParams1?.weight = progress.toFloat()
        lParams2?.weight = rightValue.toFloat()
        // в текст кнопок пишем значения переменных
        btn1?.text = progress.toString()
        btn2?.text = rightValue.toString()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
}