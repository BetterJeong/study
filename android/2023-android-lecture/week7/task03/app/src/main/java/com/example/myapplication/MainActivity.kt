package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val msg = it.data?.getStringExtra("resultdata") ?: ""
            findViewById<EditText>(R.id.editText).setText(msg)
        }

        findViewById<Button>(R.id.button)?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("numberdata", findViewById<EditText>(R.id.editText).text.toString())
            activityResult.launch(intent)
        }
    }
}