package com.clovis.dataprovider.data.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.clovis.dataprovider.data.models.PopulationType

@Dao
interface PopulationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun savePopulationType(population: PopulationType)

    @Delete
    fun deletePost(population: PopulationType)

    @Update
    fun updatePopulation(population: PopulationType)

    @Query("SELECT * FROM Populations")
    fun getAllPopulation(): List<PopulationType>?

    @Query("SELECT * FROM Populations")
    fun getAllPopulations(): LiveData<List<PopulationType>>

    @Query("SELECT * FROM Populations WHERE name = :checkTitle")
    fun findPopulation(checkTitle: String): LiveData<List<PopulationType>>

    @Query("SELECT * FROM Populations WHERE id = :id")
    fun findPopulationWithId(id: String): LiveData<List<PopulationType>>

    @Query("DELETE FROM Populations")
    fun deleteAllPopulations()
}