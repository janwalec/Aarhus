package com.example.jan_walczak
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.PackageManagerCompat.LOG_TAG


@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScaffold() {
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Menu") },
                navigationIcon = {
                    IconButton(onClick = { Log.v(LOG_TAG, "Menu act") }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                    }
                },
                actions = {
                    IconButton(onClick = { Log.v(LOG_TAG, "Add act")}) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "add")
                    }
                    IconButton(onClick = { Log.v(LOG_TAG, "Search act")}) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "search")
                    }
                }
            )
        },
        /*top bar ends*/
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { Log.v(LOG_TAG, "Build activated")}) {
                        Icon(imageVector = Icons.Default.Build, contentDescription = "build")
                    }
                    IconButton(onClick = { Log.v(LOG_TAG, "Settings")}) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "settings")
                    }
                    IconButton(onClick = { Log.v(LOG_TAG, "edit")}) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "edit")
                    }
                }
            }
        }


        /*Scaffold ends*/
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Cat(Modifier.fillMaxSize())
            val menuItemModels = listOf(
                MenuModel(imageVector = Icons.Default.Home, "Home"),
                MenuModel(imageVector = Icons.Default.DateRange, "Calendar")
            )
            //Drawer(menuItemModels)
        }
    }
}