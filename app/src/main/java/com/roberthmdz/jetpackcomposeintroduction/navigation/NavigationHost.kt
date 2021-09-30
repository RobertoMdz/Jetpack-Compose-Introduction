package com.roberthmdz.jetpackcomposeintroduction.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.roberthmdz.jetpackcomposeintroduction.navigation.Destinations.*
import com.roberthmdz.jetpackcomposeintroduction.presentation.screens.Screen1
import com.roberthmdz.jetpackcomposeintroduction.presentation.screens.Screen2
import com.roberthmdz.jetpackcomposeintroduction.presentation.screens.Screen3

@Composable
fun NavigationHost(
    navController: NavHostController,
    darkMode: MutableState<Boolean>
) {

    NavHost(navController = navController, startDestination = Screen1.route) {
        composable(Screen1.route) {

            Screen1(
                navegarPantalla2 = { newText ->
                    navController.navigate(Screen2.createRoute(newText))
                }
            )
        }

        composable(
            Screen2.route,
            arguments = listOf(navArgument("newText") { defaultValue = "Screen2"})
        ) { navBackStackEntry ->
            val newText = navBackStackEntry.arguments?.getString("newText")
            requireNotNull(newText)
            Screen2(newText, darkMode)
        }

        composable(Screen3.route) {
            Screen3()
        }
    }

}