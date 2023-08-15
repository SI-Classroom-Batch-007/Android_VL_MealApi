package com.syntax_institut.syntaxkantine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.syntax_institut.syntaxkantine.MainViewModel
import com.syntax_institut.syntaxkantine.adapter.MealsByCategoryAdapter
import com.syntax_institut.syntaxkantine.databinding.MealsByCategoryFragmentBinding

class MealsByCategoryFragment: Fragment() {

    private lateinit var binding: MealsByCategoryFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MealsByCategoryFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.mealsByCategory.observe(viewLifecycleOwner) { mealsByCat ->
            binding.rvMealsByCat.adapter = MealsByCategoryAdapter(mealsByCat)
        }
    }

}