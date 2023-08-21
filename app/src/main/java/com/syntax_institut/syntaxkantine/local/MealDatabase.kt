package com.syntax_institut.syntaxkantine.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.syntax_institut.syntaxkantine.model.Category
import com.syntax_institut.syntaxkantine.model.Meal

@Database(entities = [Meal::class], version = 1)
abstract class MealDatabase: RoomDatabase() {

    abstract val mealDao: MealDao

    companion object {

        private lateinit var dbInstance: MealDatabase

        fun getDatabase(context: Context): MealDatabase {
            synchronized(this) {

                if (!this::dbInstance.isInitialized) {
                    dbInstance = Room.databaseBuilder(
                        context.applicationContext,
                        MealDatabase::class.java,
                        "meal_database"
                    ).build()
                }
                return dbInstance
            }
        }

    }


}