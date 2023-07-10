package com.android.lab.ui.main.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.android.lab.databinding.FragmentHomeBinding
import kotlin.random.Random.Default.nextInt

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val strings = listOf("Wonderful!", "Nice!", "Beautiful!")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val sharedPreferences = requireActivity().getSharedPreferences("USER_PREF", Context.MODE_PRIVATE)
        val userName = sharedPreferences.getString("USER_NAME", null)

        binding.usernameInput.setText(userName)

        binding.pokemonImage.setOnClickListener {
            binding.wonderfulTextView.text = strings[nextInt(0, 3)]
        }

        binding.usernameInput.addTextChangedListener {
            sharedPreferences.edit() {
                putString("USER_NAME", it.toString())
                apply()
            }
        }

        return binding.root
    }
}