package com.syntax_institut.syntaxkantine.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.syntaxkantine.MainViewModel
import com.syntax_institut.syntaxkantine.R
import com.syntax_institut.syntaxkantine.databinding.CategoryItemBinding
import com.syntax_institut.syntaxkantine.model.Category

class CategoryAdapter(
    private val dataSet: List<Category>,
    private val viewModel: MainViewModel
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(val binding: CategoryItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = dataSet[position]
        holder.binding.tvCategoryTitle.text = item.title
        holder.binding.ivCategory.load(item.image)
        holder.binding.cvCategory.setOnClickListener {
            viewModel.getMealsByCategory(item.title)
            holder.itemView.findNavController().navigate(R.id.mealsByCategoryFragment)
        }
    }

}