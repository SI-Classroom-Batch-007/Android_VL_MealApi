package com.syntax_institut.syntaxkantine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.syntax_institut.syntaxkantine.MainViewModel
import com.syntax_institut.syntaxkantine.databinding.HomeFragmentBinding

class HomeFragment: Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btNext.setOnClickListener {
            viewModel.getRandomMeal()
        }

        viewModel.randomMeal.observe(viewLifecycleOwner) { meal ->
            if (meal != null) {
                binding.tvTitle.text = meal.title
                binding.tvCategory.text = meal.category
                binding.ivMeal.load(meal.image)
            }
        }


    }

}