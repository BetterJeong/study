package com.example.task07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task07.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            Snackbar.make(it, "TEST", Snackbar.LENGTH_SHORT).show()
        }

        binding.recyclerView.adapter =
    }
}