package com.android.lab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.android.lab.databinding.FragmentFirstBinding
import kotlin.random.Random.Default.nextInt

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private val strings = listOf("Wonderful!", "Nice!", "Beautiful!")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        binding.pokemonImage.setOnClickListener {
            binding.wonderfulTextView.text = strings[nextInt(0, 3)]
        }

        return binding.root
    }
}