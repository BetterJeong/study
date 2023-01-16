package com.example.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<Button>(R.id.button)
        tv.text = "학번 2171110"

        with (tv) {
            setOnClickListener { text = "TEST " + count++ }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        println("destroyed")
    }
}