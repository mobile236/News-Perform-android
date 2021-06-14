package com.news.perform.ui.country

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.news.perform.databinding.CountryItemBinding

class CountryAdapter(private val countryData: List<String>):
    RecyclerView.Adapter<CountryAdapter.ItemHolder>() {

    private var countryItem: CountryItemBinding? = null
    private val binding get() = countryItem!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        countryItem = CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(countryData[position])
    }

    override fun getItemCount() = countryData.size


    inner class ItemHolder(itemView: CountryItemBinding): RecyclerView.ViewHolder(itemView.root){
        fun bind(countryName: String) {
            binding.country.text = countryName
        }
    }
}