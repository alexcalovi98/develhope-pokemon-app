package com.android.lab

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lab.databinding.FragmentPokemonBinding
import com.android.lab.repository.PokeAPI
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        //Retrofit test

        //Retrofit client creation
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeAPI = retrofit.create(PokeAPI::class.java)

        lifecycleScope.launch {
            val pokemonResult = pokeAPI.getPokemon()
            pokemonResult.results.forEach {
                Log.d(TAG, "$it")
            }
        }
    }

    companion object {
        val TAG: String = PokemonFragment::class.java.simpleName
    }
}