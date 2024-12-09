package com.example.fabioviewmodelroomapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.fabioviewmodelroomapp.model.*
import com.example.fabioviewmodelroomapp.view.App
import com.example.fabioviewmodelroomapp.viewmodel.MapViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = MapDatabase.getDatabase(this)
        val markerDao = database.markerDao()
        val markerTypeDao = database.markerTypeDao()

        val mapViewModel = MapViewModel(markerDao, markerTypeDao)

        setContent {
            App(mapViewModel)
        }
    }
}