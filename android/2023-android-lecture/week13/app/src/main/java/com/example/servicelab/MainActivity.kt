package com.example.servicelab

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var myService: MyService? = null

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            myService = (service as MyService.LocalBinder).getService()
        }
        override fun onServiceDisconnected(name: ComponentName?) {
            myService = null
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this, MyService::class.java).also {
            bindService(it, serviceConnection, BIND_AUTO_CREATE) // Bound 서비스 bind, 결과가 serviceConnection으로 전달
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(serviceConnection)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonGet)
        val textView = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
//            Intent(this, MyService::class.java).also {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    intent.putExtra("init", 0)
//                    startForegroundService(it)
//                } else {
//                    startService(it)
//                }
//            }
            textView.text = "${myService?.tickCount}"
        }
    }
}