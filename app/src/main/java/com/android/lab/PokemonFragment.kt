package com.android.lab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lab.databinding.FragmentPokemonBinding

class PokemonFragment : Fragment() {

    private lateinit var binding: FragmentPokemonBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonList = listOf<PokemonItem>(PokemonItem(android.R.drawable.ic_menu_report_image, R.string.mewtwo))
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = PokemonAdapter(pokemonList)
        binding.recyclerView.adapter = adapter
    }
}