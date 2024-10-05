package com.example.moja_aplikacja.views
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.moja_aplikacja.menu.CatMini
import com.example.moja_aplikacja.menu.CatMiniItem


@SuppressLint("RestrictedApi")
@Composable
fun BuyCats(catList: List<CatMini>) {

    val catCount = catList.size

    val myModifier = Modifier
        .width(200.dp)
        .height(250.dp)
        .padding(10.dp)

    Box(contentAlignment = Alignment.Center) {
        Column {
            for (row in 0 until 3) {
                Row {

                    for (column in 0 until 2) {
                        val index = row * 2 + column
                        if(index < catCount) {
                            val item = catList[index]

                            CatMiniItem(catMini = item, modifier = myModifier.background(Color.Transparent))

                        }

                    }
                }
            }
        }
    }



}