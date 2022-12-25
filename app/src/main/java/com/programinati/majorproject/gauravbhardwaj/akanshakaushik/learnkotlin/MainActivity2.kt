package com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.databinding.ActivityStartBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}