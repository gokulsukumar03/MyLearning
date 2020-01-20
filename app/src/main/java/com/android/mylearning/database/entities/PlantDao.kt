package com.android.mylearning.database.entities

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlantDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(plants : List<Plant>)

    @Query("SELECT * FROM plants WHERE id =:plantId")
    fun getPlant(plantId : String) : LiveData<Plant>

}