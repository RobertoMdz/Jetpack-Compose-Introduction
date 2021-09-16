package com.roberthmdz.jetpackcomposeintroduction

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.roberthmdz.jetpackcomposeintroduction.Destinations.*

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    
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
            Screen2(newText)
        }
    }
    
}