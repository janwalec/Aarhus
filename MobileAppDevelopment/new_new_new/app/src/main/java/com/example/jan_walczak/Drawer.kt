package com.example.jan_walczak

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            ModalDrawerSheet(modifier = Modifier.fillMaxWidth(0.7f)) {
                Button(onClick = {scope.launch {drawerState.close()}}) {
                    Text("Close")

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
        Column {
            Button(onClick = {scope.launch {drawerState.open()}}) {
                Text("Open")
            }
            content()
        }

    }
}