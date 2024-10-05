package com.example.moja_aplikacja.menu

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("RestrictedApi")
@Composable
fun CatMiniItem(catMini: CatMini, modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .background(Color.Transparent)
        .fillMaxSize()
        .clickable { catMini.action() }
        .border(1.dp, Color.Blue)
        ) {
        Column {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = catMini.text,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(catMini.id),
                    contentDescription = "cat",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
