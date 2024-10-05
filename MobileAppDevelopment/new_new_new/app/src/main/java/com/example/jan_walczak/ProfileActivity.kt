package com.example.jan_walczak

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.jan_walczak.ui.theme.Jan_walczakTheme
import kotlinx.coroutines.launch


class ProfileActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jan_walczakTheme() {
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                val models = listOf(
                    MenuModel(Icons.Default.Home, "Home") {
                        scope.launch {
                            drawerState.close()
                            val intent = android.content.Intent(this@ProfileActivity, HomeActivity22::class.java)
                            intent.addFlags(android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            startActivity(intent)
                        }
                    },
                    MenuModel(Icons.Default.Search, "Search") {
                        scope.launch {
                            drawerState.close()
                            val intent = Intent(this@ProfileActivity, ProfileActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            startActivity(intent)
                        }
                    },
                    MenuModel(Icons.Default.Settings, "Settings") {
                        scope.launch {
                            drawerState.close()
                            val intent = android.content.Intent(this@ProfileActivity, SettingsActivity::class.java)
                            intent.addFlags(android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            startActivity(intent)
                        }
                    }
                )

                Scaffold( topBar = {
                    TopAppBar(title = {}, navigationIcon = {
                        IconButton(onClick = {finish()}) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "back")
                        }
                    })
                }
                ) { padding ->
                    Box(
                        modifier = Modifier
                            .padding(padding)
                            .fillMaxSize()
                    ) {
                        Drawer(models) {
                            Profile(modifier = Modifier.fillMaxSize())
                        }
                    }
                }
            }
        }

    }
}