package uk.ac.tees.mad.d3812242.presentation.navigation

sealed class Routes {

    data object SplashScreen:Routes()

    data object OnBoardingScreen:Routes()

    data object LoginScreen:Routes()

    data object SignUpScreen:Routes()

    data object HomeScreen:Routes()

    data object RecipeDetailScreen:Routes()

}