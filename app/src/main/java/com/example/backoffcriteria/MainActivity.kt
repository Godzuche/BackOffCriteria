package com.example.backoffcriteria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.backoffcriteria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnWorkerFail = binding.btnWorkerFail
        val btnWorkerRetry = binding.btnWorkerRetry

        btnWorkerFail.setOnClickListener {

        }
    }
}