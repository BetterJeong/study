package com.example.servicelab

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlinx.coroutines.*

class MyService : Service() {
    var tickCount:Int = 0
    private val binder = LocalBinder()
    private lateinit var scope: CoroutineScope

    inner class LocalBinder : Binder() {
        fun getService() = this@MyService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            tickCount = intent.getIntExtra("init", 0)
        }

        scope = CoroutineScope(Dispatchers.Default).apply {
            launch {
                for (i in 1..10) {
                    delay(1000) // 1000 ms 대기
                    withContext(Dispatchers.Main) {
                        tickCount++
                    }
                }
            }
        }

        return super.onStartCommand(intent, flags, startId) // START_STICKY, NOT_STICKY, REDELIVERY_INTENT
    }
}