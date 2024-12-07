package uk.ac.tees.mad.d3812242.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.mad.d3812242.data.localmanager.DataStoreManager
import uk.ac.tees.mad.d3812242.presentation.ui.onboardingscreen.OnBoardingScreen
import uk.ac.tees.mad.d3812242.presentation.ui.splashscreen.SplashScreen
import uk.ac.tees.mad.d3812242.presentation.ui.createaccountscreen.CreateAccountScreen
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.HomeScreen
import uk.ac.tees.mad.d3812242.presentation.ui.loginscreen.LoginScreen
import uk.ac.tees.mad.d3812242.presentation.ui.searchhistoryscreen.UKFoodSearchHistoryScreen

@Composable
fun CookBookComposableNavigationSystem(context: Context){

    val navController= rememberNavController()

    NavHost(startDestination = Routes.SplashScreen, navController = navController) {


        composable<Routes.SplashScreen> {
            SplashScreen(navController, DataStoreManager(context))
        }

        composable<Routes.LoginScreen> {
            LoginScreen()
        }

        composable<Routes.SignUpScreen> {
            CreateAccountScreen()
        }

        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Routes.OnBoardingScreen> {
            OnBoardingScreen(dataStoreManager = DataStoreManager(context),navController)
        }
        composable<Routes.SearchScreen> {

             UKFoodSearchHistoryScreen(navController)

        }

    }

}