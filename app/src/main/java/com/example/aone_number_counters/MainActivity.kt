package com.example.aone_number_counters

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits", "ApplySharedPref")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sp = getSharedPreferences("Counters", MODE_PRIVATE)
        var editor = sp.edit()
        var a:Int = sp.getInt("Count", 0)
        number_tv.text = a.toString()
        number_img.setOnClickListener {
            a++
            number_tv.text = a.toString()
        }
        number_buSave.setOnClickListener {
            editor.putInt("Count", a)
            editor.commit()
            Toast.makeText(this, "Save Complete", Toast.LENGTH_SHORT).show()
        }
        number_buClear.setOnClickListener {
            editor.clear()
            a = 0
            number_tv.text = a.toString()
            editor.commit()
            Toast.makeText(this, "Clear Complete", Toast.LENGTH_SHORT).show()
        }
    }
}