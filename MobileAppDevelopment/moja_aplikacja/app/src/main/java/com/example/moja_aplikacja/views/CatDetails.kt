package com.example.moja_aplikacja.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moja_aplikacja.R
import com.example.moja_aplikacja.activities.CatDetailsActivity

@Composable
fun CatDetails() {
    val customFont = FontFamily(Font(R.font.eracake))
    val textColor = Color(0xFF3675F4)

    val context = LocalContext.current
    val intent = remember { (context as? CatDetailsActivity)?.intent }

    val imageId: Int = intent!!.getIntExtra("catImageResId", -1)
    val name: String = intent.getStringExtra("name")!!
    val description: String = intent.getStringExtra("description")!!
    val price: Int = intent.getIntExtra("price", -1)

    Column {
        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(100.dp)
            , contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
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
                .height(300.dp)
            , contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "cat",
                contentScale = ContentScale.Fit,
                modifier = androidx.compose.ui.Modifier.fillMaxSize()
            )
        }
        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(100.dp)
            , contentAlignment = Alignment.Center
        ) {
            Text(
                text = description,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
                textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(100.dp)
            , contentAlignment = Alignment.Center
        ) {
            Text(
                text = "price: " + price.toString(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
                textAlign = TextAlign.Center
            )
        }
    }


}
