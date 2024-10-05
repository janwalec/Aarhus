package com.example.jj_walczak

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.PackageManagerCompat.LOG_TAG

@SuppressLint("RestrictedApi", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppScaffold(content: @Composable () -> Unit) {
    Scaffold(

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
                    IconButton(onClick = { Log.v(LOG_TAG, "Build activated") }) {
                        Icon(imageVector = Icons.Default.Build, contentDescription = "build")
                    }
                    IconButton(onClick = { Log.v(LOG_TAG, "Settings") }) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "settings")
                    }
                    IconButton(onClick = { Log.v(LOG_TAG, "edit") }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "edit")
                    }
                }
            }
        },
        topBar = {
            CustomTopBar()
        }){


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, bottom = 50.dp)

        ) {
            //content()
        }
    }
}



