package com.syntax_institut.syntaxkantine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.syntax_institut.syntaxkantine.MainViewModel
import com.syntax_institut.syntaxkantine.adapter.MealAdapter
import com.syntax_institut.syntaxkantine.databinding.FavouritesFragmentBinding

class FavouritesFragment: Fragment() {

    private lateinit var binding: FavouritesFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FavouritesFragmentBinding.inflate(layoutInflater)
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        viewModel.loadAllMeals()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.favouriteMeals.observe(viewLifecycleOwner) { favourites ->
            binding.rvFavourites.adapter = MealAdapter(favourites)
        }

    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}