package com.syntax_institut.syntaxkantine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.syntax_institut.syntaxkantine.MainViewModel
import com.syntax_institut.syntaxkantine.adapter.CategoryAdapter
import com.syntax_institut.syntaxkantine.databinding.CategoryFragmentBinding

class CategoryFragment : Fragment() {

    private lateinit var binding: CategoryFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CategoryFragmentBinding.inflate(layoutInflater)
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.categories.observe(viewLifecycleOwner) { categories ->
            binding.rvCategories.adapter = CategoryAdapter(categories, viewModel)
        }
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}