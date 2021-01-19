package com.android.fundamentals.workshop03

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Ws03LocationsDao {

    @Query("SELECT * FROM locations_ws03 ORDER BY _id ASC")
    suspend fun getAll(): List<Ws03LocationEntity>

    @Insert
    suspend fun insert(location: Ws03LocationEntity)

    @Query("DELETE FROM locations_ws03 WHERE _id == :id")
    suspend fun deleteById(id: Long)
}