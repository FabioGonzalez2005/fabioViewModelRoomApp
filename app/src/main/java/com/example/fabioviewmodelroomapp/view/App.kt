package com.example.fabioviewmodelroomapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fabioviewmodelroomapp.model.Marker
import com.example.fabioviewmodelroomapp.viewmodel.MapViewModel

@Composable
fun MainApp(viewModel: MapViewModel) {
    val markers by viewModel.allMarkers.collectAsState(initial = emptyList())
    var name by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Marcadores",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(markers) { marker ->
                MarkerItem(marker = marker, onDeleteClick = {
                    viewModel.deleteMarker(marker)
                })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = latitude,
                onValueChange = { latitude = it },
                label = { Text("Latitud") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = longitude,
                onValueChange = { longitude = it },
                label = { Text("Longitud") },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (name.isNotEmpty() && latitude.isNotEmpty() && longitude.isNotEmpty()) {
                    val marker = Marker(
                        name = name,
                        latitude = latitude,
                        longitude = longitude,
                        markerTypeId = 1 // Puedes cambiar esto según sea necesario
                    )
                    viewModel.addMarker(marker)
                    name = ""
                    latitude = ""
                    longitude = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Añadir Marcador")
        }
    }
}

@Composable
fun MarkerItem(marker: Marker, onDeleteClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${marker.name} (${marker.latitude}, ${marker.longitude})",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = onDeleteClick) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Eliminar marcador"
            )
        }
    }
}
