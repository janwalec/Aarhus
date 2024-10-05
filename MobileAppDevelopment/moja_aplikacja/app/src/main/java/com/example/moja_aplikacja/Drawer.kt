package com.example.moja_aplikacja

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moja_aplikacja.menu.MenuItem
import com.example.moja_aplikacja.menu.MenuModel
import kotlinx.coroutines.launch

@SuppressLint("RestrictedApi")
@Composable
fun Drawer(models: List<MenuModel>, content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier
                .fillMaxWidth(0.7f)
            ) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 5.dp),

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        onClick = {scope.launch {drawerState.close()}}
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "back",
                            tint = Color.Red)
                    }
                }
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    models.forEach {
                        MenuItem(
                            menuModel = it.copy(action = {
                                scope.launch {
                                    it.action()
                                    drawerState.close()
                                }
                            })
                        )
                    }
                }
            }
        } ) {
        Row {
            Button(
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                onClick = {scope.launch {drawerState.open()}}

            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "menu", tint = Color.Red)
            }

        }

        Box(modifier = Modifier.padding(top=60.dp).background(Color(0x2A757575)).fillMaxHeight()) {
            content()
        }


    }
}