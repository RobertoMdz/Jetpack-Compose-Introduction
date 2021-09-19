package com.roberthmdz.jetpackcomposeintroduction.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.roberthmdz.jetpackcomposeintroduction.navigation.Destinations

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<Destinations>
) {
    val currentRoute = currentRoute(navController)

    BottomNavigation {
       items.forEach { screen ->
           BottomNavigationItem(
               icon = { Icon(imageVector = screen.icon, contentDescription = screen.title)},
               label = { Text(screen.title)},
               selected = currentRoute == screen.route,
               onClick = {
                   navController.navigate(screen.route) {
                       // this code remove the back stack when user move to another bottom navigation bar screen
                       popUpTo(navController.graph.findStartDestination().id) {
                           saveState = true
                       }
                       // this code prevent that not generate more stack when user tap repeatedly the same bottom navigation bar item
                       launchSingleTop = true
                   }
               },
               alwaysShowLabel = false
           )
       }
    }
}

@Composable
private fun currentRoute (navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}