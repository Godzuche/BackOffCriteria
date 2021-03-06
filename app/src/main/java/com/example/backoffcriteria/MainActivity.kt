package com.example.backoffcriteria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.backoffcriteria.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val workManager = WorkManager.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnWorkerFail = binding.btnWorkerFail
        val btnWorkerRetry = binding.btnWorkerRetry

        btnWorkerFail.setOnClickListener {
            val workRequest = OneTimeWorkRequestBuilder<WorkerFail>().build()
            workManager.enqueue(workRequest)
        }

        btnWorkerRetry.setOnClickListener {
            val workRequest = OneTimeWorkRequestBuilder<WorkerRetry>()
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    10,
                    TimeUnit.SECONDS
                )
                .build()
            workManager.enqueue(workRequest)
        }
    }
}