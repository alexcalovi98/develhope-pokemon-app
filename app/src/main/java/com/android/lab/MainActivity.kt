package com.android.lab

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.lab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.navigationFirstButton.setOnClickListener { Log.d(TAG, "Navigate to first fragment") }
        binding.navigationSecondButton.setOnClickListener { Log.d(TAG, "Navigate to second fragment") }
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}