package com.clovis.dataprovider.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.clovis.dataprovider.data.models.PopulationType


@Database(entities = [PopulationType::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun populationDao(): PopulationDao

    companion object {
        private var instance: AppDatabase? = null
        private const val DB = "PopulationDb"

        fun getDataBaseObject(applicationContext: Context): AppDatabase {

            if (instance == null) instance = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, DB
            )
                .allowMainThreadQueries()
                .build()

            return instance!!
        }
    }
}