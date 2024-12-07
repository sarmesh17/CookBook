package uk.ac.tees.mad.d3812242.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.mad.d3812242.data.localmanager.DataStoreManager
import uk.ac.tees.mad.d3812242.presentation.ui.bookmarkscreen.BookmarkScreen
import uk.ac.tees.mad.d3812242.presentation.ui.onboardingscreen.OnBoardingScreen
import uk.ac.tees.mad.d3812242.presentation.ui.splashscreen.SplashScreen
import uk.ac.tees.mad.d3812242.presentation.ui.createaccountscreen.CreateAccountScreen
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.HomeScreen
import uk.ac.tees.mad.d3812242.presentation.ui.loginscreen.LoginScreen
import uk.ac.tees.mad.d3812242.presentation.ui.profilescreen.ProfileSettingsScreen
import uk.ac.tees.mad.d3812242.presentation.ui.reipedetailscreen.RecipeDetailScreenWithAnimation
import uk.ac.tees.mad.d3812242.presentation.ui.searchhistoryscreen.UKFoodSearchHistoryScreen
import uk.ac.tees.mad.d3812242.presentation.viewmodels.RecipeViewModel

@Composable
fun CookBookComposableNavigationSystem(context: Context,/*viewModel: RecipeViewModel*/){

    val navController= rememberNavController()

    NavHost(startDestination = Routes.SplashScreen, navController = navController) {


        composable<Routes.SplashScreen> {
            SplashScreen(navController, DataStoreManager(context))
        }

        composable<Routes.LoginScreen> {
            LoginScreen(navController, hiltViewModel())
        }

        composable<Routes.SignUpScreen> {
            CreateAccountScreen(navController, hiltViewModel(), hiltViewModel())
        }

        composable<Routes.HomeScreen> {
            HomeScreen(navController, viewModel = RecipeViewModel(), signUpScreenViewModel = hiltViewModel() )
        }

        composable<Routes.OnBoardingScreen> {
            OnBoardingScreen(dataStoreManager = DataStoreManager(context),navController)
        }
        composable<Routes.SearchScreen> {

             UKFoodSearchHistoryScreen(navController)

        }

        composable<Routes.BookMarkScreen> {
            BookmarkScreen(viewModel= RecipeViewModel(),navController)
        }

        composable<Routes.RecipeDetailScreen> {

            RecipeDetailScreenWithAnimation(it)

        }

        composable<Routes.SignUpScreen> {
            CreateAccountScreen(navController, hiltViewModel(), hiltViewModel())
        }

        composable<Routes.ProfileScreen> {
            ProfileSettingsScreen(navController, signUpScreenViewModel = hiltViewModel())
        }

    }

}