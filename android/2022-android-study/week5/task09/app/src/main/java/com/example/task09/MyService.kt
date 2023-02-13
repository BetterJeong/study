package com.example.task09

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlinx.coroutines.*

class MyService : Service() {

    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService() = this@MyService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun doService(param : String) {
        println("do service $param")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {
            for (i in 1..10) {
                delay(1000)
                println("#")
            }
        }

        scope.launch {
            for (i in 1..10) {
                delay(1000)
                println("$")
            }
        }

        println("onstartcommand")
        return super.onStartCommand(intent, flags, startId)
    }
}