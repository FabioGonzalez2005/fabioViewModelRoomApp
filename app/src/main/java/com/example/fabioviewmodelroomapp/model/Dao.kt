package com.example.fabioviewmodelroomapp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Query("DELETE FROM favorites WHERE markerId = :markerId")
    suspend fun removeFavorite(markerId: Int)

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): Flow<List<Favorite>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE markerId = :markerId)")
    suspend fun isFavorite(markerId: Int): Boolean
}

@Dao
interface MarkerDao {
    @Insert
    suspend fun insert(marker: Marker)

    @Delete
    suspend fun delete(marker: Marker)

    @Query("SELECT * FROM markers")
    fun getAllMarkers(): Flow<List<Marker>>

    @Query("SELECT * FROM markers WHERE id = :id")
    fun getMarkerById(id: Int): Flow<Marker?>
}