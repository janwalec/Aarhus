package com.example.moja_aplikacja.menu


data class CatMini(
    val id: Int,
    val text: String,
    val action: () -> Unit = {}
)