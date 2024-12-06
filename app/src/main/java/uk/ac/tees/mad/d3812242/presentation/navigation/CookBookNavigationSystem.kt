package uk.ac.tees.mad.d3812242.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.mad.d3812242.presentation.splashscreen.SplashScreen
import uk.ac.tees.mad.d3812242.presentation.ui.createaccountscreen.CreateAccountScreen
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.HomeScreen
import uk.ac.tees.mad.d3812242.presentation.ui.loginscreen.LoginScreen

@Composable
fun CookBookComposableSystem(){

    val navController= rememberNavController()

    NavHost(startDestination = Routes.SplashScreen, navController = navController) {


        composable<Routes.SplashScreen> {
            SplashScreen(navController)
        }

        composable<Routes.LoginScreen> {
            LoginScreen()
        }

        composable<Routes.SignUpScreen> {
            CreateAccountScreen()
        }

        composable<Routes.HomeScreen> {
            HomeScreen()
        }

    }

}