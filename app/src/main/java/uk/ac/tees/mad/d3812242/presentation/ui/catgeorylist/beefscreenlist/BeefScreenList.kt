package uk.ac.tees.mad.d3812242.presentation.ui.catgeorylist.beefscreenlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.ui.catgeorylist.RecipeList
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard.Recipe

@Composable
fun BeefListScreen(navHostController: NavHostController) {

    val beefRecipes = listOf(
        Recipe(
            name = "Beef Stroganoff",
            description = "A creamy and hearty beef dish with mushrooms and pasta.",
            imageRes = R.drawable.beef_stroganoff, // Replace with your actual image resource
            rating = "⭐ 4.7",
            ingredients = listOf(
                "500 grams beef strips",
                "1 onion, sliced",
                "200 grams mushrooms, sliced",
                "1 cup beef broth",
                "1/2 cup sour cream",
                "Salt and pepper to taste",
                "Pasta or rice for serving"
            ),
            steps = listOf(
                "Sauté onions and mushrooms until tender.",
                "Cook beef strips until browned.",
                "Add beef broth, simmer, and stir in sour cream. Serve with pasta or rice."
            ),
            category = "Main Dish"
        ),
        Recipe(
            name = "Classic Beef Burger",
            description = "A juicy beef patty served with fresh toppings and a soft bun.",
            imageRes = R.drawable.beef_burger, // Replace with your actual image resource
            rating = "⭐ 4.8",
            ingredients = listOf(
                "500 grams ground beef",
                "1 egg",
                "1 tsp garlic powder",
                "1 tsp onion powder",
                "Salt and pepper to taste",
                "Burger buns and toppings of choice"
            ),
            steps = listOf(
                "Mix beef, egg, and spices, then form patties.",
                "Grill patties until cooked to preference.",
                "Assemble the burger with buns and toppings. Serve hot."
            ),
            category = "Snack"
        ),
        Recipe(
            name = "Beef Curry",
            description = "A flavorful and spicy curry made with tender beef chunks.",
            imageRes = R.drawable.beef_curry, // Replace with your actual image resource
            rating = "⭐ 4.6",
            ingredients = listOf(
                "500 grams beef chunks",
                "2 onions, chopped",
                "2 tomatoes, chopped",
                "1 tsp turmeric",
                "1 tsp chili powder",
                "1 tsp garam masala",
                "Salt to taste"
            ),
            steps = listOf(
                "Sauté onions and tomatoes with spices.",
                "Add beef chunks and cook until tender.",
                "Simmer until the curry thickens. Serve with rice or bread."
            ),
            category = "Curry"
        ),
        Recipe(
            name = "Beef Tacos",
            description = "Mexican-style tacos filled with spiced beef and fresh toppings.",
            imageRes = R.drawable.beef_tacos, // Replace with your actual image resource
            rating = "⭐ 4.9",
            ingredients = listOf(
                "500 grams ground beef",
                "1 tsp cumin",
                "1 tsp chili powder",
                "Salt to taste",
                "Taco shells",
                "Lettuce, tomato, cheese, and salsa for toppings"
            ),
            steps = listOf(
                "Cook ground beef with spices until browned.",
                "Fill taco shells with beef and desired toppings.",
                "Serve immediately."
            ),
            category = "Snack"
        ),
        Recipe(
            name = "Beef Meatballs",
            description = "Juicy and flavorful beef meatballs in a tangy tomato sauce.",
            imageRes = R.drawable.beef_meatballs, // Replace with your actual image resource
            rating = "⭐ 4.7",
            ingredients = listOf(
                "500 grams ground beef",
                "1/2 cup breadcrumbs",
                "1 egg",
                "1 tsp garlic powder",
                "1 tsp Italian seasoning",
                "Salt and pepper to taste",
                "Tomato sauce for serving"
            ),
            steps = listOf(
                "Mix beef, breadcrumbs, egg, and spices to form meatballs.",
                "Cook meatballs in a pan until browned.",
                "Simmer in tomato sauce and serve hot."
            ),
            category = "Appetizer"
        )
    )

    Scaffold {
        Column(modifier = Modifier.padding(it)) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {

                Text("Beef Recipes", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            LazyColumn() {

                items(beefRecipes) { beefData ->

                    RecipeList(recipe = beefData, navHostController = navHostController)

                }

            }

        }
    }

}
