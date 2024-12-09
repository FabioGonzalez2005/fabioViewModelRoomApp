package com.example.fabioviewmodelroomapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fabioviewmodelroomapp.model.MarkerDao
import com.example.fabioviewmodelroomapp.model.MarkerTypeDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import com.example.fabioviewmodelroomapp.model.Marker
import com.example.fabioviewmodelroomapp.model.TypeMarker

class MapViewModel(
    private val markerDao: MarkerDao,
    private val markerTypeDao: MarkerTypeDao
) : ViewModel() {

    val allMarkers: Flow<List<Marker>> = markerDao.getAllMarkers()
    val allMarkerTypes: Flow<List<TypeMarker>> = markerTypeDao.getAllMarkerTypes()

}
