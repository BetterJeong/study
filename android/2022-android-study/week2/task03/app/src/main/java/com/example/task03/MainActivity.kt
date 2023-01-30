package com.example.task03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task03.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            binding.textView2.text = binding.editTextTextPersonName.text
            val pet ="Dog: ${binding.radioDog.isChecked}, Cat: ${binding.radioCat.isChecked}"
            Snackbar.make(it, pet, Snackbar.LENGTH_SHORT).show()
        }

        when (binding.radioGroup.checkedRadioButtonId) {
            R.id.radioDog -> print("Dog checked")
            R.id.radioCat -> print("Cat checked")
        }
    }
}