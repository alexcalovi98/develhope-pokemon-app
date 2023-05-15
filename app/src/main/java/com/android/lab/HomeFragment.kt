package com.android.lab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.pokemonImage.setOnClickListener {
            binding.wonderfulTextView.text = strings[nextInt(0, 3)]
        }

        return binding.root
    }
}