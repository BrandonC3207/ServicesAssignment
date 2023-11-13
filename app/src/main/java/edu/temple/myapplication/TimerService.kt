package edu.temple.myapplication

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.util.Log


class TimerService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        if (intent != null) {
            runTimer(intent.getIntExtra("COUNTDOWN_NUMBER", 0))
        }

        return super.onStartCommand(intent, flags, startId)
    }

    fun runTimer(startValue: Int){
        Thread{
            for (i in startValue downTo 0){
                Log.d("Countdown", i.toString())
                Thread.sleep(100)
            }
        }.start()
    }

}