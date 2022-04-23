package com.example.p14muenu2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.p14muenu2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu)
    }
//This one works as well as xml menu code
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menu.add(0, 1, 0,"add")
//        menu.add(0, 2, 0,"edit")
//        menu.add(0, 3, 3,"delete")
//        menu.add(0, 3, 4,"delete file")
//        menu.add(1, 4, 1,"copy")
//        menu.add(1, 5, 2,"paste")
//        menu.add(1, 6, 4,"exit")
//        menu.add(1, 7, 5,"new file")
//        return super.onCreateOptionsMenu(menu)
//    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        binding.apply {
            setContentView(binding.root)
            menu?.setGroupVisible(1, chbExtMenu.isChecked)
            return super.onPrepareOptionsMenu(menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        binding.apply {
            setContentView(binding.root)
            val sb: StringBuilder = StringBuilder()
                .append("Item Menu")
                .append("\r\n groupId: " + item.getGroupId().toString())
                .append("\r\n itemId: " + item.getItemId().toString())
                .append("\r\n order: " + item.getOrder().toString())
                .append("\r\n title: " + item.getTitle())
            textView.text = sb
            return super.onOptionsItemSelected(item)
        }
    }
}