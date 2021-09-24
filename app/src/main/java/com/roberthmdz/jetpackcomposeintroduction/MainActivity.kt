package com.roberthmdz.jetpackcomposeintroduction

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.roberthmdz.jetpackcomposeintroduction.navigation.Destinations.*

import com.roberthmdz.jetpackcomposeintroduction.navigation.NavigationHost
import com.roberthmdz.jetpackcomposeintroduction.presentation.components.BottomNavigationBar
import com.roberthmdz.jetpackcomposeintroduction.presentation.components.Dialog
import com.roberthmdz.jetpackcomposeintroduction.presentation.components.Drawer
import com.roberthmdz.jetpackcomposeintroduction.presentation.components.TopBar
import kotlinx.coroutines.launch

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
    val openDialog = remember { mutableStateOf(false)}

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
        topBar = {
            TopBar(
                scope = scope,
                scaffoldState = scaffoldState,
                openDialog = {  openDialog.value = true },
                displaySnackBar = {
                   scope.launch {
                        val result = scaffoldState.snackbarHostState.showSnackbar(
                            message = "New SnackBar",
                            duration = SnackbarDuration.Short,
                            actionLabel = "Accept"
                        )

                       when(result) {
                           SnackbarResult.ActionPerformed -> {
                               Log.d("Main Activity", "SnackBar Accionado")
                           }
                           SnackbarResult.Dismissed -> {
                               Log.d("Main Activity", "SnackBar Ignorado")
                           }
                       }
                   }



                }
            )
        },
        drawerContent = { Drawer(scope, scaffoldState, navController , items = navigationItems)},
        drawerGesturesEnabled = true
    ) {
        NavigationHost(navController)
    }
    
    Dialog(showDialog = openDialog.value, dismissDialog = { openDialog.value = false} )

    
}