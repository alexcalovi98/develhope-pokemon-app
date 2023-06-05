package com.android.lab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lab.databinding.FragmentPokemonBinding
import com.android.lab.repository.PokeAPI
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale

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

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = PokemonAdapter()
        binding.recyclerView.adapter = adapter

        //Retrofit client creation
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeAPI = retrofit.create(PokeAPI::class.java)

        lifecycleScope.launch {
            val pokemonResult = pokeAPI.getPokemon(20, 0)
            val pokemonItems = mutableListOf<PokemonItem>()
            pokemonResult.results.forEach {
                val d = pokeAPI.getPokemonDetails(it.name)
                pokemonItems.add(PokemonItem(
                    d.sprites.other.dreamWorld.frontDefault,
                    it.name.replaceFirstChar { c -> c.uppercase() }
                ))
            }
            adapter.addItems(pokemonItems)
        }
    }

    companion object {
        val TAG: String = PokemonFragment::class.java.simpleName
    }
}