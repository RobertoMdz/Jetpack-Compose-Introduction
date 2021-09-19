package com.roberthmdz.jetpackcomposeintroduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.roberthmdz.jetpackcomposeintroduction.navigation.Destinations.*

import com.roberthmdz.jetpackcomposeintroduction.navigation.NavigationHost
import com.roberthmdz.jetpackcomposeintroduction.presentation.components.BottomNavigationBar

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
    val navigationItems = listOf(
        Screen1,
        Screen2,
        Screen3
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, items = navigationItems)
        }
    ) {
        NavigationHost(navController)
    }
    
}