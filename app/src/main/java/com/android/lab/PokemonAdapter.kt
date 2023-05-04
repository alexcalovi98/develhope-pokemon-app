package com.android.lab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.lab.databinding.PokemonItemBinding

class PokemonAdapter(private val items: List<String>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val pokemonItemBinding = DataBindingUtil
            .inflate<PokemonItemBinding>(LayoutInflater.from(parent.context), R.layout.pokemon_item, parent, false)
        return ViewHolder(pokemonItemBinding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(private val binding: PokemonItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemonName: String) {
            binding.pokemonName.text = pokemonName
        }
    }
}