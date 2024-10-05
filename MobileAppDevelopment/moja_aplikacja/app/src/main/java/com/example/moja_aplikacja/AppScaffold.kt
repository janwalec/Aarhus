package com.example.moja_aplikacja

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.moja_aplikacja.menu.MenuModel

@SuppressLint("RestrictedApi", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppScaffold(models: List<MenuModel>, content: @Composable () -> Unit) {
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(50.dp).fillMaxWidth()
            ) {
                IconButton(onClick = {
                    (context as? Activity)?.finish()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back"
                    )
                }
            }
        }
    ) {
        Drawer(models) {
            content()
        }


    }

}
