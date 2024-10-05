package com.example.moja_aplikacja.activities

import android.annotation.SuppressLint
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
import com.example.moja_aplikacja.R
import com.example.moja_aplikacja.menu.CatMini
import com.example.moja_aplikacja.menu.MenuModel
import com.example.moja_aplikacja.ui.theme.Moja_aplikacjaTheme
import com.example.moja_aplikacja.views.BuyCats
import kotlinx.coroutines.launch


class BuyCatsActivity : ComponentActivity() {
    @SuppressLint("RestrictedApi")
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
                            val intent = Intent(this@BuyCatsActivity, HomeActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            startActivity(intent)
                        }
                    },

                    MenuModel(Icons.Default.ShoppingCart, "Buy cats")  {
                        scope.launch {
                            drawerState.close()
                            val intent = Intent(this@BuyCatsActivity, BuyCatsActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            startActivity(intent)
                        }
                    },

                    MenuModel(Icons.Default.Person, "Profile")  {
                        scope.launch {
                            drawerState.close()
                            val intent = Intent(this@BuyCatsActivity, ProfileActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            startActivity(intent)
                        }
                    }


                )

                val catList = listOf(
                    CatMini(R.drawable.el_gato, "el gato") {
                        val intent = Intent(this@BuyCatsActivity, CatDetailsActivity::class.java)
                        intent.putExtra("name", "el gato")
                        intent.putExtra("catImageResId", R.drawable.el_gato)
                        intent.putExtra("description", "very nice cat")
                        intent.putExtra("price", 20)


                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    },
                    CatMini(R.drawable.silly_cat, "silly cat") {
                        val intent = Intent(this@BuyCatsActivity, CatDetailsActivity::class.java)
                        intent.putExtra("name", "silly cat")
                        intent.putExtra("catImageResId", R.drawable.silly_cat)
                        intent.putExtra("description", "what a fool!")
                        intent.putExtra("price", 16)

                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    },
                    CatMini(R.drawable.grumpy_cat, "grumpy cat") {
                        val intent = Intent(this@BuyCatsActivity, CatDetailsActivity::class.java)
                        intent.putExtra("name", "grumpy cat")
                        intent.putExtra("catImageResId", R.drawable.grumpy_cat)
                        intent.putExtra("description", "he's very grumpy")
                        intent.putExtra("price", 13)

                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    },
                    CatMini(R.drawable.flip_flop, "flip flop cat") {
                        val intent = Intent(this@BuyCatsActivity, CatDetailsActivity::class.java)
                        intent.putExtra("name", "flip flop cat")
                        intent.putExtra("catImageResId", R.drawable.flip_flop)
                        intent.putExtra("description", "great for swimming pool")
                        intent.putExtra("price", 15)

                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    },
                    CatMini(R.drawable.angry_cat, "angry cat") {
                        val intent = Intent(this@BuyCatsActivity, CatDetailsActivity::class.java)
                        intent.putExtra("name", "angry cat")
                        intent.putExtra("catImageResId", R.drawable.angry_cat)
                        intent.putExtra("description", "don't fool around")
                        intent.putExtra("price", 10)

                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    },
                )

                AppScaffold(models) {
                    BuyCats(catList)
                }
            }
        }

    }
}