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
