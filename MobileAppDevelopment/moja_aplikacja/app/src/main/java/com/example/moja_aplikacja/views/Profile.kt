package com.example.moja_aplikacja.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moja_aplikacja.R


@Composable
fun Profile() {
    val textColor = Color(0xFF3675F4)
    val customFont = FontFamily(Font(R.font.eracake))

    Column {
        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(100.dp), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "here is your \n\nprofile",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
                fontFamily = customFont,
                textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(100.dp), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "comming soon",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
                textAlign = TextAlign.Center
            )
        }


    }
}