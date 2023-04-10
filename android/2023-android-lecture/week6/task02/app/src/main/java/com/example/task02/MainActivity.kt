package com.example.task02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task02.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.radioDog.isChecked) {
                binding.textView.text = binding.radioDog.text
            }
            else {
                binding.textView.text = binding.radioCat.text
            }
        }
    }
}