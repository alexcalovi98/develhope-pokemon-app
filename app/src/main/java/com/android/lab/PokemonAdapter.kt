package com.android.lab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lab.databinding.PokemonItemBinding

class PokemonAdapter(private val items : List<PokemonItem>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder> () {

    inner class ViewHolder(private val binding : PokemonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item : PokemonItem) {
            binding.pokemonImage.setImageResource(item.image)
            binding.textPokemon.setText(item.text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])

    }

}