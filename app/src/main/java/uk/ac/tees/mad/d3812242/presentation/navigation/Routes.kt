package uk.ac.tees.mad.d3812242.presentation.navigation

import kotlinx.serialization.Serializable
import okhttp3.Route
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard.Recipe

sealed class Routes {

    @Serializable
    data object SplashScreen : Routes()

    @Serializable
    data object OnBoardingScreen : Routes()

    @Serializable
    data object LoginScreen : Routes()

    @Serializable
    data object SignUpScreen : Routes()

    @Serializable
    data object HomeScreen : Routes()

    @Serializable
    data object VegListScreen : Routes()

    @Serializable
    data class RecipeDetailScreen(
        val name: String,
        val description: String,
        val imageRes: Int,
        val rating: String,
        val ingredients: List<String>,
        val steps: List<String> ) : Routes()

    @Serializable
    data object SearchScreen : Routes(
    )

    @Serializable
    data object BookMarkScreen : Routes()

    @Serializable
    data object ProfileScreen: Routes()

    @Serializable
    data object BeefListScreen:Routes()

    @Serializable
    data object ChickenScreenList:Routes()

}