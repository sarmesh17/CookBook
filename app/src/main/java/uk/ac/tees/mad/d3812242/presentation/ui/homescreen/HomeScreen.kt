package uk.ac.tees.mad.d3812242.presentation.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.navigation.Routes
import uk.ac.tees.mad.d3812242.presentation.navigation.bottomnavigation.BottomNavigationBar
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.categoriesrow.CategoriesRow
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.categoriesrow.Category
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.foodselectionButtons.HorizontalScrollable
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard.Recipe
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard.RecipeCard
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.scrollabletextbutton.ScrollableTextButtonsRow
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.searchbar.SearchBar
import uk.ac.tees.mad.d3812242.presentation.viewmodels.RecipeViewModel

@Composable
fun HomeScreen(navHostController: NavHostController,viewModel: RecipeViewModel) {

    var searchText by remember {
        mutableStateOf("")
    }

    val recipes = listOf(
        Recipe(
            name = "Spiced Fried Chicken",
            description = "A delicious spiced fried chicken recipe perfect for all occasions.",
            imageRes = R.drawable.fried_chicken_rice_img,
            rating = "4.5",
            ingredients = listOf(
                "200 grams of chicken",
                "6 tbsp olive oil",
                "3 tsp soy sauce",
                "2 tsp chili powder",
                "1 clove garlic, minced",
                "Salt to taste"
            ),
            steps = listOf(
                "Marinate the chicken with chili powder, soy sauce, and salt.",
                "Heat olive oil in a pan and fry the chicken until golden brown.",
                "Garnish with fresh herbs and serve."
            ),
            category = "Chili chicken" // Category added
        ),
        Recipe(
            name = "Spicy Chicken",
            description = "A quick and easy spicy chicken recipe for spice lovers.",
            imageRes = R.drawable.chili_chicken_img,
            rating = "4.2",
            ingredients = listOf(
                "500 grams of chicken breast",
                "2 tbsp chili sauce",
                "1 tbsp soy sauce",
                "2 cloves garlic, minced",
                "1 tbsp vegetable oil",
                "Salt and pepper to taste"
            ),
            steps = listOf(
                "Cut chicken breast into cubes.",
                "Marinate with chili sauce, soy sauce, and garlic.",
                "Heat oil in a pan and cook the chicken until fully done.",
                "Serve hot with rice or noodles."
            ),
            category = "Chili chicken" // Category added
        ),
        Recipe(
            name = "Crispy Tofu Delight",
            description = "Crunchy tofu cubes served with a tangy dipping sauce.",
            imageRes = R.drawable.crispy_tofu_img,
            rating = "4.7",
            ingredients = listOf(
                "200 grams of tofu",
                "3 tbsp cornstarch",
                "1 tbsp soy sauce",
                "1 tsp garlic powder",
                "Vegetable oil for frying"
            ),
            steps = listOf(
                "Cut tofu into bite-sized cubes.",
                "Coat tofu in soy sauce, then toss in cornstarch mixed with garlic powder.",
                "Fry until golden brown and crispy."
            ),
            category = "Crispy tofu" // Category added
        ),
        Recipe(
            name = "Crispy Tofu Stick",
            description = "Golden fried tofu sticks perfect for snacks or appetizers.",
            imageRes = R.drawable.crispy_tofu_stick_img,
            rating = "4.4",
            ingredients = listOf(
                "200 grams of tofu",
                "Breadcrumbs",
                "1 egg, beaten",
                "Salt and pepper to taste",
                "Vegetable oil for frying"
            ),
            steps = listOf(
                "Cut tofu into stick shapes.",
                "Dip each stick in the beaten egg, then coat with breadcrumbs.",
                "Fry in hot oil until golden and crispy."
            ),
            category = "Crispy tofu" // Category added
        ),
        Recipe(
            name = "Golden Fried Fish",
            description = "Crispy fried fish with a golden-brown crust.",
            imageRes = R.drawable.fried_fish,
            rating = "4.6",
            ingredients = listOf(
                "2 fish fillets",
                "1 cup flour",
                "1 tsp paprika",
                "1/2 tsp black pepper",
                "Vegetable oil for frying"
            ),
            steps = listOf(
                "Season the fish with paprika, black pepper, and salt.",
                "Coat the fish fillets in flour.",
                "Fry in hot oil until crispy and golden brown."
            ),
            category = "Fried fish" // Category added
        ),
        Recipe(
            name = "Traditional Sunday Roast",
            description = "A hearty roast perfect for Sunday family gatherings.",
            imageRes = R.drawable.sunday_roast,
            rating = "4.8",
            ingredients = listOf(
                "1 whole chicken",
                "2 cups potatoes, peeled and chopped",
                "2 carrots, chopped",
                "2 tbsp olive oil",
                "Salt and pepper to taste",
                "Rosemary sprigs"
            ),
            steps = listOf(
                "Preheat oven to 200°C (400°F).",
                "Season the chicken with salt, pepper, and rosemary.",
                "Place the chicken, potatoes, and carrots on a baking tray.",
                "Drizzle with olive oil and roast for 1 hour or until cooked."
            ),
            category = "Roast" // Category added
        ),
        Recipe(
            name = "All-Time Favorite Chicken",
            description = "A simple and classic chicken recipe loved by everyone.",
            imageRes = R.drawable.fried_chicken_rice_img,
            rating = "4.3",
            ingredients = listOf(
                "500 grams of chicken",
                "3 tbsp soy sauce",
                "2 tsp ginger paste",
                "1 tsp sugar",
                "Vegetable oil for frying"
            ),
            steps = listOf(
                "Marinate chicken with soy sauce, ginger paste, and sugar for 30 minutes.",
                "Heat oil in a pan and fry chicken until golden brown.",
                "Serve with steamed rice or veggies."
            ),
            category = "Chili chicken" // Category added
        )
    )


    val poppinsFontFamily = FontFamily(

        Font(resId = R.font.poppins_semibold)
    )

    val asianDishItem = listOf( // Asian dishes
        "🍣 Sushi", "🍜 Ramen", "🥟 Dumplings", "🍚 Fried Rice", "🥢 Noodles"
    )

    val europeanDishItem = listOf(
        // European dishes
        "🥖 Baguette", "🥘 Paella", "🍕 Pizza", "🍝 Spaghetti", "🍲 Stew",
    )

    var selectedCategory by remember { mutableStateOf("All") }
    var selectedTab by remember { mutableStateOf("Home") }

    val categories = listOf(
        Category("Vegetarian", R.drawable.vegetarian_img),
        Category("Beef", R.drawable.beef_img),
        Category("Chicken", R.drawable.chicken_img),
        Category("Seafood", R.drawable.seafood_img),
        Category("Desserts", R.drawable.desserts_img)
    )

    val verticalScrollState = rememberScrollState()


    Scaffold(bottomBar = {
        BottomNavigationBar(onTabSelected = {
            selectedTab = it

            when (selectedTab) {
                "Search" -> {

                    navHostController.navigate(Routes.SearchScreen)

                }
                "Saved" -> {

                    navHostController.navigate(Routes.BookMarkScreen)
                }
                "Profile" -> {
                    navHostController.navigate(Routes.ProfileScreen)
                }
                else -> {
                    navHostController.navigate(Routes.HomeScreen)
                }
            }
        }, selectedTab = selectedTab)
    }) { innerpadding ->

        Column(modifier = Modifier
            .padding(innerpadding)
            .verticalScroll(verticalScrollState)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ashish_chanchlani),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )

                Spacer(Modifier.width(16.dp))

                Column {
                    // Greeting
                    Text(
                        "Welcome, \uD83D\uDC4B\uD83C\uDFFB",
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        color = Color(0xFF9CA3AF)
                    )

                    Spacer(modifier = Modifier.height(4.dp))
                    // name
                    Text(
                        "Ashish Chanchalani",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        letterSpacing = 0.sp
                    )
                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {

                    Icon(
                        painter = painterResource(R.drawable.notification_icon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            SearchBar(navHostController = navHostController)


            Text(
                "What's in your fridge?",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(18.dp), fontFamily = poppinsFontFamily,
            )

            HorizontalScrollable(asianDishItem)
            HorizontalScrollable(europeanDishItem)

            Spacer(Modifier.height(20.dp))

            ScrollableTextButtonsRow(
                selectedCategory = selectedCategory,
                onCategorySelected = { selectedCategory = it }
            )

            val filteredRecipes = if (selectedCategory == "All") {
                recipes
            } else {
                recipes.filter { it.category == selectedCategory }
            }

            LazyRow(modifier = Modifier.wrapContentSize()) {
                items(filteredRecipes.size) { index ->
                    RecipeCard(recipe = filteredRecipes[index], viewModel = viewModel,navHostController=navHostController)
                }
            }

            //categories section
            CategoriesRow(categories)


        }


    }


}