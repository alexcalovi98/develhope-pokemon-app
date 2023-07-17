package com.android.lab.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.android.lab.R
import com.android.lab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener {
            val navController = binding.navHostFragment.findNavController()
            when(it.itemId) {
                R.id.action_home -> navController.navigate(R.id.homeFragment)
                R.id.action_pokemon -> navController.navigate(R.id.pokemonFragment)
                else -> return@setOnItemSelectedListener false
            }
            return@setOnItemSelectedListener true
        }
    }



    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}