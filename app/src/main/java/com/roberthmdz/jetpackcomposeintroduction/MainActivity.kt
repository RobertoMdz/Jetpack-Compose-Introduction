package com.roberthmdz.jetpackcomposeintroduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.roberthmdz.jetpackcomposeintroduction.navigation.Destinations.*

import com.roberthmdz.jetpackcomposeintroduction.navigation.NavigationHost
import com.roberthmdz.jetpackcomposeintroduction.presentation.components.BottomNavigationBar
import com.roberthmdz.jetpackcomposeintroduction.presentation.components.Drawer
import com.roberthmdz.jetpackcomposeintroduction.presentation.components.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()

    val navigationItems = listOf(
        Screen1,
        Screen2,
        Screen3
    )

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNavigationBar(navController = navController, items = navigationItems)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon( imageVector = Icons.Default.Add, contentDescription = "Fab icon")
            }
        },
        isFloatingActionButtonDocked = false,
        floatingActionButtonPosition = FabPosition.End,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState)},
        drawerContent = { Drawer(scope, scaffoldState, navController , items = navigationItems)},
        drawerGesturesEnabled = true
    ) {
        NavigationHost(navController)
    }
    
}