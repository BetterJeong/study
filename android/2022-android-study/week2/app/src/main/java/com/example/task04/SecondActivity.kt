package com.example.task04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.task04.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {
    val TAG = "Lifecycle-Second"
    lateinit var binding: ActivitySecondBinding
    var cnt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cnt = Integer.parseInt(intent?.getStringExtra("count"))

        binding.ChangedtextView.text = cnt.toString()

        binding.buttonIncrease.setOnClickListener {
            cnt++
            binding.ChangedtextView.text = cnt.toString()
        }

        binding.buttonDecrease.setOnClickListener {
            cnt--
            binding.ChangedtextView.text = cnt.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")

        val resultIntent = Intent()
        resultIntent.putExtra("return", cnt)
        setResult(RESULT_OK, resultIntent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }
}