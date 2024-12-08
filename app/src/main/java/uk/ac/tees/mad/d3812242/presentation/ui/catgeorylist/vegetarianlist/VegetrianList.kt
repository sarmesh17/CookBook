package uk.ac.tees.mad.d3812242.presentation.ui.catgeorylist.vegetarianlist

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.ui.catgeorylist.RecipeList
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard.Recipe

@Composable
fun VegetarianListScreen(navHostController: NavHostController) {

    val vegetarianRecipes = listOf(
        Recipe(
            name = "Vegetable Stir Fry",
            description = "A quick and healthy stir fry with mixed vegetables.",
            imageRes = R.drawable.vegetable_stir_fry, // Replace with your actual image resource
            rating = "⭐ 4.3",
            ingredients = listOf(
                "1 cup broccoli florets",
                "1 carrot, sliced",
                "1 bell pepper, sliced",
                "2 tbsp olive oil",
                "2 tbsp soy sauce",
                "1 tsp sesame oil",
                "Garlic to taste"
            ),
            steps = listOf(
                "Heat olive oil in a pan and sauté garlic.",
                "Add the vegetables and stir-fry until tender.",
                "Drizzle with soy and sesame oil, and serve."
            ),
            category = "Stir Fry"
        ),
        Recipe(
            name = "Chickpea Salad",
            description = "A refreshing chickpea salad with a tangy dressing.",
            imageRes = R.drawable.chickpea_salad, // Replace with your actual image resource
            rating = "⭐ 4.5",
            ingredients = listOf(
                "1 can chickpeas, drained",
                "1 cucumber, diced",
                "1 tomato, diced",
                "1 red onion, diced",
                "1 tbsp olive oil",
                "1 tbsp lemon juice",
                "Salt and pepper to taste"
            ),
            steps = listOf(
                "In a bowl, combine chickpeas, cucumber, tomato, and onion.",
                "Drizzle with olive oil and lemon juice.",
                "Season with salt and pepper, toss well, and serve."
            ),
            category = "Salad"
        ),
        Recipe(
            name = "Paneer Tikka",
            description = "A flavorful grilled paneer dish marinated with spices.",
            imageRes = R.drawable.paneer_tikka, // Replace with your actual image resource
            rating = "⭐ 4.8",
            ingredients = listOf(
                "250 grams paneer, cubed",
                "1/2 cup yogurt",
                "1 tsp turmeric",
                "1 tsp chili powder",
                "1 tsp garam masala",
                "Salt to taste",
                "1 tbsp lemon juice"
            ),
            steps = listOf(
                "Mix yogurt and spices to create the marinade.",
                "Marinate the paneer cubes for at least an hour.",
                "Grill the paneer until golden and serve with chutney."
            ),
            category = "Appetizer"
        ),
        Recipe(
            name = "Vegetable Biryani",
            description = "A fragrant rice dish with mixed vegetables and spices.",
            imageRes = R.drawable.vegetable_biryani, // Replace with your actual image resource
            rating = "⭐ 4.7",
            ingredients = listOf(
                "1 cup basmati rice",
                "1/2 cup peas",
                "1 potato, diced",
                "1 onion, sliced",
                "1 tsp garam masala",
                "1 tsp cumin",
                "1 cinnamon stick",
                "4-5 cloves"
            ),
            steps = listOf(
                "Cook rice separately, adding spices for flavor.",
                "Sauté vegetables and onions with garam masala.",
                "Layer cooked rice and vegetables, cook on low heat, and serve."
            ),
            category = "Rice Dish"
        ),
        Recipe(
            name = "Mushroom Soup",
            description = "A creamy and comforting mushroom soup.",
            imageRes = R.drawable.mushroom_soup, // Replace with your actual image resource
            rating = "⭐ 4.6",
            ingredients = listOf(
                "200 grams mushrooms, sliced",
                "1 onion, chopped",
                "1 cup vegetable broth",
                "1/2 cup cream",
                "2 tbsp butter",
                "Salt and pepper to taste"
            ),
            steps = listOf(
                "Sauté onions and mushrooms in butter until tender.",
                "Add vegetable broth and let simmer for 10 minutes.",
                "Blend the soup and stir in cream. Season and serve."
            ),
            category = "Soup"
        ),
        Recipe(
            name = "Palak Paneer",
            description = "A delicious spinach curry with paneer.",
            imageRes = R.drawable.palak_paneer, // Replace with your actual image resource
            rating = "⭐ 4.4",
            ingredients = listOf(
                "200 grams paneer, cubed",
                "2 cups spinach, blanched",
                "1 onion, chopped",
                "1 tomato, chopped",
                "1 tsp cumin",
                "1/2 tsp turmeric",
                "1/2 tsp garam masala"
            ),
            steps = listOf(
                "Cook onions and tomatoes with spices.",
                "Blend the spinach into a puree and add to the pan.",
                "Add paneer cubes and cook for 10 minutes. Serve with roti."
            ),
            category = "Curry"
        ),
        Recipe(
            name = "Aloo Gobi",
            description = "A flavorful curry made with potatoes and cauliflower.",
            imageRes = R.drawable.aloo_gobi, // Replace with your actual image resource
            rating = "⭐ 4.2",
            ingredients = listOf(
                "1 cauliflower, cut into florets",
                "2 potatoes, cubed",
                "1 tsp cumin",
                "1 tsp turmeric",
                "1 tsp chili powder",
                "Salt to taste"
            ),
            steps = listOf(
                "Heat oil and sauté cumin seeds.",
                "Add potatoes and cauliflower, cook with spices until tender.",
                "Serve with rice or roti."
            ),
            category = "Curry"
        ),
        Recipe(
            name = "Rajma",
            description = "A hearty kidney bean curry with a rich tomato gravy.",
            imageRes = R.drawable.rajma, // Replace with your actual image resource
            rating = "⭐ 4.9",
            ingredients = listOf(
                "1 cup kidney beans (soaked overnight)",
                "2 tomatoes, chopped",
                "1 onion, chopped",
                "1 tsp cumin",
                "1 tsp garam masala",
                "Salt to taste"
            ),
            steps = listOf(
                "Cook kidney beans until tender.",
                "Sauté onions and tomatoes with spices.",
                "Add beans to the gravy and simmer for 15 minutes. Serve with rice."
            ),
            category = "Beans"
        ),
        Recipe(
            name = "Tofu Stir Fry",
            description = "A savory stir-fry dish made with tofu and vegetables.",
            imageRes = R.drawable.tofu_stir_fry, // Replace with your actual image resource
            rating = "⭐ 4.4",
            ingredients = listOf(
                "200 grams tofu, cubed",
                "1 bell pepper, sliced",
                "1 onion, sliced",
                "2 tbsp soy sauce",
                "1 tbsp sesame oil",
                "1 tbsp ginger, minced"
            ),
            steps = listOf(
                "Fry tofu cubes until golden brown.",
                "Sauté vegetables with soy sauce and sesame oil.",
                "Mix in the tofu and stir-fry for 5 minutes. Serve hot."
            ),
            category = "Stir Fry"
        ),
        Recipe(
            name = "Cauliflower Rice",
            description = "A low-carb alternative to rice made with cauliflower.",
            imageRes = R.drawable.cauliflower_rice, // Replace with your actual image resource
            rating = "⭐ 4.1",
            ingredients = listOf(
                "1 medium cauliflower, grated",
                "1 tbsp olive oil",
                "1 onion, chopped",
                "1 garlic clove, minced",
                "Salt and pepper to taste"
            ),
            steps = listOf(
                "Grate the cauliflower into rice-sized pieces.",
                "Sauté onions and garlic in olive oil.",
                "Add cauliflower rice, season, and cook until tender."
            ),
            category = "Side Dish"
        )
    )


    Scaffold {
        Column(modifier = Modifier.padding(it)) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {

                Text("Vegetarian Screen", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            LazyColumn() {

                items(vegetarianRecipes) { vegData ->

                    RecipeList(recipe = vegData, navHostController = navHostController)

                }

            }

        }
    }

}