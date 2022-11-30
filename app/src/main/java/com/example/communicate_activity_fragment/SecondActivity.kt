package com.example.communicate_activity_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.communicate_activity_fragment.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataMainActivity()
    }

    private fun getDataMainActivity() {
        val data = intent?.getStringExtra(ACTIVYTY_TO_ACTIVITY)
        binding.tvSecondActivity.setText(data)
    }
}