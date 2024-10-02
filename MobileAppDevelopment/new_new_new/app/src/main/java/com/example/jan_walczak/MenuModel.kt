package com.example.jan_walczak

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuModel(
    val imageVector: ImageVector,
    val text: String,
    val action: () -> Unit = {}
)