package com.android.lab.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.lab.data.DataDependencyInjection
import com.android.lab.databinding.FragmentHomeBinding
import com.android.lab.ui.main.pokemon.PokemonViewModel
import kotlin.random.Random.Default.nextInt

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory()
    }

    private val strings = listOf("Wonderful!", "Nice!", "Beautiful!")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val userName = viewModel.getUserName()

        binding.usernameInput.setText(userName)

        binding.pokemonImage.setOnClickListener {
            binding.wonderfulTextView.text = strings[nextInt(0, 3)]
        }

        binding.usernameInput.addTextChangedListener {
            viewModel.saveUserName(it.toString())
        }

        return binding.root
    }
}