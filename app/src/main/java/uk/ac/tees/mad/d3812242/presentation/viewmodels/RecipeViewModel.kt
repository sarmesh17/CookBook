package uk.ac.tees.mad.d3812242.presentation.viewmodels


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard.Recipe

class RecipeViewModel : ViewModel() {
    // List to hold bookmarked recipes
    val bookmarkedRecipes = mutableStateListOf<Recipe>()

    // Function to toggle bookmark
    fun toggleBookmark(recipe:Recipe) {
        if (bookmarkedRecipes.contains(recipe)) {
            bookmarkedRecipes.remove(recipe)
        } else {
            bookmarkedRecipes.add(recipe)
        }
    }
}
