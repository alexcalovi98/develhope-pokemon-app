package com.android.lab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lab.databinding.FragmentPokemonBinding

class PokemonFragment : Fragment() {

    private lateinit var binding: FragmentPokemonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pokemon, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonList = listOf("Pikachu", "Bulbasaur", "Charmander", "Squirtle")

        binding.pokemonList.adapter = PokemonAdapter(pokemonList)
        binding.pokemonList.layoutManager = LinearLayoutManager(context)
    }
}