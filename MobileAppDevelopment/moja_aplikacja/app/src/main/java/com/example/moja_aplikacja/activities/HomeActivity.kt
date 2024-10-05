package com.example.moja_aplikacja.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import com.example.moja_aplikacja.AppScaffold
import com.example.moja_aplikacja.views.Home
import com.example.moja_aplikacja.menu.MenuModel
import com.example.moja_aplikacja.ui.theme.Moja_aplikacjaTheme
import kotlinx.coroutines.launch


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Moja_aplikacjaTheme {
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
                    MenuModel(Icons.Default.ShoppingCart, "Buy cats") {
                          scope.launch {
                              drawerState.close()
                              val intent = Intent(this@HomeActivity, BuyCatsActivity::class.java)
                              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                              startActivity(intent)
                          }
                      },
                    MenuModel(Icons.Default.Person, "Profile")  {
                        scope.launch {
                            drawerState.close()
                            val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            startActivity(intent)
                        }
                    }

                )

                AppScaffold(models) {
                    Home()
                }
            }
        }

    }
}