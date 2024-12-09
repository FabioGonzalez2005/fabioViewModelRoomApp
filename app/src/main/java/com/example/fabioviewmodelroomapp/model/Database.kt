package com.example.fabioviewmodelroomapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Marker::class, TypeMarker::class, Favorite::class], version = 4)
abstract class MapDatabase : RoomDatabase() {

    abstract fun markerDao(): MarkerDao
    abstract fun typeMarkerDao(): TypeMarkerDao
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: MapDatabase? = null

        fun getDatabase(context: Context): MapDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MapDatabase::class.java,
                    "map_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
