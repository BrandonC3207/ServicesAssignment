package edu.temple.myapplication

import android.content.AsyncQueryHandler
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    lateinit var countDown: EditText
    lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countDown = findViewById(R.id.editText)
        button = findViewById(R.id.button)

        button.setOnClickListener{
            val countDownValue = countDown.text.toString().toInt()
            startService(Intent(this, TimerService::class.java).apply{
                putExtra("COUNTDOWN_NUMBER", countDownValue)
            })
        }


    }
}