package uk.ac.tees.mad.d3812242.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object SplashScreen:Routes()

    @Serializable
    data object OnBoardingScreen:Routes()

    @Serializable
    data object LoginScreen:Routes()

    @Serializable
    data object HomeScreen:Routes()

    @Serializable
    data object RecipeDetailScreen:Routes()

    @Serializable
    data object SearchScreen:Routes()

    @Serializable
    data object CreateAccountScreen:Routes()

}