package com.example.jan_walczak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jan_walczak.ui.theme.Jan_walczakTheme



class MainActivity : ComponentActivity() {
    //YetAnotherActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jan_walczakTheme() {
                val state = remember {
                    mutableStateOf("Home")
                }

                val models = listOf(
                    MenuModel(
                        Icons.Default.Home,
                        "Home"
                    ) {
                        state.value = "Home"
                    },
                    MenuModel(
                        Icons.Default.Search,
                        "Search"
                    ) {
                        state.value = "Search"
                    }
                )

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { padding ->
                    Box(
                        modifier = Modifier
                            .padding(padding)
                            .fillMaxSize()
                    ) {
                        Drawer(models) {
                            //when (state.value) {
                            Cat(modifier = Modifier.fillMaxSize())
                            // "Search" -> Cat2(modifier = Modifier.fillMaxSize())
                            //}
                        }
                    }
                }

            }
        }
    }
    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Lesson_2Theme {
                FirstScaffold()
                //SecondScaffold()
            }
        }
    }
    */
}


@Composable
fun Cat(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.cat),
        contentDescription = "cat"
    )
}

@Composable
fun Cat2(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.cat_2),
        contentDescription = "cat"
    )
}

/*
@SuppressLint("RestrictedApi")
@Composable
fun SecondScaffold() {
    Scaffold(
        topBar = {
            CustomTopBar(
                menu = { Log.v(LOG_TAG, "Menu act") },
                add = { Log.v(LOG_TAG, "Menu act") },
                search = { Log.v(LOG_TAG, "Menu act") },
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { Log.v(LOG_TAG, "Build activated") }) {
                        Icon(imageVector = Icons.Default.Build, contentDescription = "build")
                    }
                    IconButton(onClick = { Log.v(LOG_TAG, "Settings") }) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "settings")
                    }
                    IconButton(onClick = { Log.v(LOG_TAG, "edit") }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "edit")
                    }
                }
            }
        } ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            //Cat(Modifier.fillMaxSize())
            Drawer()
        }
    }
}
*/


@Composable
fun CustomTopBar(menu: () -> Unit, add: () -> Unit, search : () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(width = 2.dp, color = Color.Black)
    ) {
        IconButton(onClick = menu) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
        }

        IconButton(onClick = add) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "add")
        }
        IconButton(onClick = search) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "search")
        }
    }
}