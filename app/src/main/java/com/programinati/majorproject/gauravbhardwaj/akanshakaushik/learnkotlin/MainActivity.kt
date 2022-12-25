package com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed(Runnable {
                                       // code
            startActivity(Intent(this,StartActivity::class.java))
            finish()
        },3000)
    }
}