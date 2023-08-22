package com.syntax_institut.syntaxkantine.helper

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MealTouchHelper(
    removeMeal: (position: Int) -> Unit
) : ItemTouchHelper(
    object : SimpleCallback(
        UP or DOWN, LEFT
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: ViewHolder, target: ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            removeMeal(position)
        }
    })