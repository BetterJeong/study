package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider

class SecondActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val msg = intent?.getStringExtra("numberdata") ?: ""
        //findViewById<TextView>(R.id.textView).text = "$msg"

        val viewModel = ViewModelProvider(this, MyViewModelFactory(Integer.parseInt(msg)))[MyViewModel::class.java]

        viewModel.countLiveData.observe(this) {
            findViewById<TextView>(R.id.textView).text = "$it"
        }

        findViewById<Button>(R.id.buttonDec)?.setOnClickListener {
            viewModel.decreaseCount()
        }

        findViewById<Button>(R.id.buttonInc)?.setOnClickListener {
            viewModel.increaseCount()
        }

        onBackPressedDispatcher.addCallback(this, object:OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val resultIntent = Intent()
                resultIntent.putExtra("resultdata", findViewById<TextView>(R.id.textView).text)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        })
    }
}