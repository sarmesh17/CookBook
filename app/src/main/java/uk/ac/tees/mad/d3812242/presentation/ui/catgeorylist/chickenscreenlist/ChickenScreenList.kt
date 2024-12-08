package uk.ac.tees.mad.d3812242.presentation.ui.catgeorylist.chickenscreenlist

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.ui.catgeorylist.RecipeList
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard.Recipe

@Composable
fun ChickenListScreen(navHostController: NavHostController) {

    val chickenRecipes = listOf(
        Recipe(
            name = "Grilled Chicken",
            description = "Juicy grilled chicken with a blend of spices.",
            imageRes = R.drawable.grilled_chicken, // Replace with your actual image resource
            rating = "⭐ 4.8",
            ingredients = listOf(
                "500 grams chicken breast",
                "1 tsp paprika",
                "1 tsp garlic powder",
                "1 tbsp olive oil",
                "Salt and pepper to taste"
            ),
            steps = listOf(
                "Marinate chicken with spices and olive oil.",
                "Grill chicken until cooked through.",
                "Serve with a side of vegetables or salad."
            ),
            category = "Main Dish"
        ),
        Recipe(
            name = "Chicken Curry",
            description = "A spicy and aromatic chicken curry.",
            imageRes = R.drawable.chicken_curry, // Replace with your actual image resource
            rating = "⭐ 4.9",
            ingredients = listOf(
                "500 grams chicken pieces",
                "2 onions, chopped",
                "2 tomatoes, chopped",
                "1 tsp turmeric",
                "1 tsp garam masala",
                "Salt to taste"
            ),
            steps = listOf(
                "Sauté onions and tomatoes with spices.",
                "Add chicken and cook until tender.",
                "Simmer until the curry thickens. Serve with rice or bread."
            ),
            category = "Curry"
        ),
        Recipe(
            name = "Chicken Alfredo Pasta",
            description = "Creamy pasta with tender chicken slices.",
            imageRes = R.drawable.chicken_alfredo, // Replace with your actual image resource
            rating = "⭐ 4.7",
            ingredients = listOf(
                "250 grams chicken breast, sliced",
                "200 grams pasta",
                "1 cup heavy cream",
                "1/2 cup parmesan cheese",
                "2 garlic cloves, minced",
                "Salt and pepper to taste"
            ),
            steps = listOf(
                "Cook pasta according to package instructions.",
                "Sauté chicken and garlic until golden.",
                "Add cream and cheese, mix with pasta, and serve."
            ),
            category = "Pasta"
        ),
        Recipe(
            name = "Chicken Tikka",
            description = "Spiced and grilled chicken skewers.",
            imageRes = R.drawable.chicken_tikka, // Replace with your actual image resource
            rating = "⭐ 4.8",
            ingredients = listOf(
                "500 grams chicken, cubed",
                "1/2 cup yogurt",
                "1 tsp turmeric",
                "1 tsp chili powder",
                "1 tsp garam masala",
                "Salt to taste",
                "Skewers for grilling"
            ),
            steps = listOf(
                "Marinate chicken cubes with yogurt and spices.",
                "Thread chicken onto skewers and grill until cooked.",
                "Serve with mint chutney."
            ),
            category = "Appetizer"
        ),
        Recipe(
            name = "Chicken Caesar Salad",
            description = "Crispy lettuce with grilled chicken and caesar dressing.",
            imageRes = R.drawable.chicken_caesar_salad, // Replace with your actual image resource
            rating = "⭐ 4.7",
            ingredients = listOf(
                "200 grams grilled chicken slices",
                "1 head romaine lettuce",
                "1/4 cup caesar dressing",
                "Croutons and parmesan cheese for garnish"
            ),
            steps = listOf(
                "Toss lettuce with caesar dressing.",
                "Top with grilled chicken, croutons, and parmesan cheese.",
                "Serve chilled."
            ),
            category = "Salad"
        )
    )

    Scaffold {
        Column(modifier = Modifier.padding(it)) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {

                Text("Chicken Recipes", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            LazyColumn() {

                items(chickenRecipes) { chickenData ->

                    RecipeList(recipe = chickenData, navHostController = navHostController)

                }

            }

        }
    }

}
