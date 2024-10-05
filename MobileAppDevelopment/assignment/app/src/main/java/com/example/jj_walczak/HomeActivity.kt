package com.example.jj_walczak

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import com.example.jj_walczak.ui.theme.Jj_walczakTheme
import kotlinx.coroutines.launch


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*Jj_walczakTheme() {
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                val models = listOf(
                    MenuModel(Icons.Default.Home, "Home") {
                        scope.launch {
                            drawerState.close()
                            val intent = Intent(this@HomeActivity, HomeActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            startActivity(intent)
                        }
                    },
                   MenuModel(Icons.Default.Search, "Search") {
                        scope.launch {
                            drawerState.close()
                            val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            startActivity(intent)
                        }
                    },/*
                    MenuModel(Icons.Default.Settings, "Settings") {
                        scope.launch {
                            drawerState.close()
                            val intent = android.content.Intent(this@com.example.jj_walczak.HomeActivity, SettingsActivity::class.java)
                            intent.addFlags(android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            startActivity(intent)
                        }
                    }*/

                )

                AppScaffold() {
                    //Profile()
                };
            }
      */  }

    }
}