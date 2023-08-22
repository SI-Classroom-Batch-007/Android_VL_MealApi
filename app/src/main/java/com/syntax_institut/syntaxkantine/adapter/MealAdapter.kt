package com.syntax_institut.syntaxkantine.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.syntaxkantine.MainViewModel
import com.syntax_institut.syntaxkantine.databinding.MealItemBinding
import com.syntax_institut.syntaxkantine.model.Meal

class MealAdapter(
    private val viewModel: MainViewModel
): RecyclerView.Adapter<MealAdapter.MealsByCategoryViewHolder>() {

    private var dataSet: List<Meal> = listOf()

    class MealsByCategoryViewHolder(val binding: MealItemBinding): RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun replaceDataSet(dataSet: List<Meal>){
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    fun removeMeal(position: Int){
        viewModel.deleteMeal(dataSet[position])
        notifyItemRemoved(position)
    }

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