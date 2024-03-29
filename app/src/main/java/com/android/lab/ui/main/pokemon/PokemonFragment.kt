package com.android.lab.ui.main.pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lab.databinding.FragmentPokemonBinding
import com.android.lab.ui.main.pokemon.adapter.PokemonAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonFragment : Fragment() {

    private val viewModel: PokemonViewModel by viewModel()

    private lateinit var binding: FragmentPokemonBinding

    private lateinit var adapter: PokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.pokemonSharedFlow.collect {
                adapter.addItems(it)
            }
        }
        //Previous Live Data
        /*viewModel.pokemonLiveData.observe(viewLifecycleOwner) {
            adapter.addItems(it)
        }*/

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = PokemonAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.downloadPokemon()
    }

    companion object {
        val TAG: String = PokemonFragment::class.java.simpleName
    }
}