package com.example.moja_aplikacja.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moja_aplikacja.R

@Composable
fun Home() {
    val textColor = Color(0xFF3675F4)
    val oppositeColor = Color(0xEFF54C36)
    val customFont = FontFamily(Font(R.font.eracake))
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                //.border(2.dp, Color.Red)

            ,contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Welcome to the \n\nCat app",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
                fontFamily = customFont,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .height(300.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.el_gato),
                contentDescription = "cat",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(50.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                //.border(2.dp, Color.Red)
        ){
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                    //.border(2.dp, Color.Red)
                    ,contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "Browse for some",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor,
                        textAlign = TextAlign.Center,
                        fontFamily = customFont
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                    //.border(2.dp, Color.Red)
                    ,contentAlignment = Alignment.Center
                ){
                    Text(
                        text = ">>> CUTE CATS <<<",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = oppositeColor,
                        textAlign = TextAlign.Center,
                        fontFamily = customFont
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                    //.border(2.dp, Color.Red)
                    ,contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "in your area!",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor,
                        textAlign = TextAlign.Center,
                        fontFamily = customFont
                    )
                }
            }

        }
    }

}