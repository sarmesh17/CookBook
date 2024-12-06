package uk.ac.tees.mad.d3812242.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun CookBookComposableSystem(){

    val navController= rememberNavController()

    NavHost(startDestination = Routes.SplashScreen, navController = navController) {




    }

}