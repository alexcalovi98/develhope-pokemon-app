package com.android.example.develhope_basketball.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.example.develhope_basketball.MyApplication
import com.android.example.develhope_basketball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val myApplication = application as MyApplication
        viewModel = myApplication.factory.create(MainViewModel::class.java)

        viewModel.gameListLiveData.observe(this) {
            val joke = it[0]
            val setup = joke.setup
            val punchline = joke.punchline
            binding.textView.text = "$setup\n$punchline"
        }
        binding.button.setOnClickListener() {
            viewModel.dataFetch()
        }
    }
}