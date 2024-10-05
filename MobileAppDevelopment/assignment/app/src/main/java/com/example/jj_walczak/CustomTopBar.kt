package com.example.jj_walczak

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jj_walczak.MenuModel

@Composable
fun CustomTopBar() {
    val state = remember {
        mutableStateOf("Home")
    }

    val models = listOf(
        MenuModel(
            Icons.Default.Home,
            "Home"
        ) {
            state.value = "Home"
        },
        MenuModel(
            Icons.Default.Search,
            "Search"
        ) {
            state.value = "Search"
        }
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black)
    )  {
        Column(modifier = Modifier
            .border(width = 5.dp, color = Color.Red)){
            Drawer(models) {}
        }

    }




}