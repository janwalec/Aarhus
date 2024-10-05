package com.example.moja_aplikacja.menu

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuModel(
    val imageVector: ImageVector,
    val text: String,
    val action: () -> Unit = {}
)