package com.syntax_institut.syntaxkantine.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.syntaxkantine.databinding.MealItemBinding
import com.syntax_institut.syntaxkantine.model.Meal

class MealAdapter(
    private val dataSet: List<Meal>
): RecyclerView.Adapter<MealAdapter.MealsByCategoryViewHolder>() {

    class MealsByCategoryViewHolder(val binding: MealItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsByCategoryViewHolder {
        val binding = MealItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealsByCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: MealsByCategoryViewHolder, position: Int) {
        val item = dataSet[position]
        holder.binding.tvMealTitle.text = item.title
        holder.binding.ivMealByCat.load(item.image)
    }

}