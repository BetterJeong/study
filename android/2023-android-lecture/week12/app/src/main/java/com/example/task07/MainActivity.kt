package com.example.task07

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.annotation.Dimension
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val name = pref.getString("Name", "Hello World!")
        val size = pref.getString("Size", "small")
        val italic = pref.getBoolean("Italic", false)

        val tv = findViewById<TextView>(R.id.textView)

        tv.text = name

        when (size) {
            "small" -> {
                tv.textSize = 10F
            }
            "medium" -> {
                tv.textSize = 14F
            }
            "big" -> {
                tv.textSize = 20F
            }
        }

        if (italic) {
            tv.setTypeface(tv.typeface, Typeface.ITALIC)
        }
        else {
            tv.setTypeface(tv.typeface, Typeface.NORMAL)
        }
    }
}