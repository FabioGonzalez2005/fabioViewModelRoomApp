package com.example.fabioviewmodelroomapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorites",
    foreignKeys = [
        ForeignKey(
            entity = Marker::class,
            parentColumns = ["id"],
            childColumns = ["markerId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Favorite(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val markerId: Int
)

@Entity(
    tableName = "markers",
    foreignKeys = [
        ForeignKey(
            entity = TypeMarker::class,
            parentColumns = ["id"],
            childColumns = ["markerTypeId"],
            onDelete = ForeignKey.SET_NULL
        )
    ]
)
data class Marker(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val latitude: String,
    val longitude: String,
    val description: String? = null,
    val markerTypeId: Int
)
