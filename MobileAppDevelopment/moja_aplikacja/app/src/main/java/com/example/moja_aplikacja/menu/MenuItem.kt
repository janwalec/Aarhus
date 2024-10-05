package com.example.moja_aplikacja.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MenuItem(menuModel: MenuModel, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(start = 5.dp, end = 5.dp)
            .background(color = MaterialTheme.colorScheme.onSurface)
            .fillMaxWidth()
            .height(48.dp)
            .clickable {menuModel.action()},

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        Icon(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .fillMaxHeight(),

            imageVector = menuModel.imageVector,
            contentDescription = menuModel.text, tint = MaterialTheme.colorScheme.surface
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = menuModel.text,
            style = TextStyle(
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.surface
            )
        )

    }
}