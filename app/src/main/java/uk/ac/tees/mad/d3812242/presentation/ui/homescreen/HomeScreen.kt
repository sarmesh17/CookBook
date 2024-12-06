package uk.ac.tees.mad.d3812242.presentation.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.ui.bottomnavigation.BottomNavigationBar
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.categoriesrow.CategoriesRow
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.categoriesrow.Category
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.foodselectionButtons.HorizontalScrollable
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard.RecipeCard
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard.recipes
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.scrollabletextbutton.ScrollableTextButtonsRow
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.searchbar.SearchBar

@Composable
@Preview(showSystemUi = true)
fun HomeScreen() {

    var searchText by remember {
        mutableStateOf("")
    }


    val poppinsFontFamily = FontFamily(

        Font(resId = R.font.poppins_semibold)
    )

    val asianDishItem= listOf( // Asian dishes
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

    val verticalScrollState= rememberScrollState()


    Scaffold(bottomBar = { BottomNavigationBar(onTabSelected = {selectedTab = it}, selectedTab = selectedTab ) }) { innerpadding ->

        Column(modifier = Modifier.padding(innerpadding).verticalScroll(verticalScrollState)) {

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
                    Text("Ashish Chanchalani", fontSize = 16.sp, fontFamily = poppinsFontFamily,letterSpacing = 0.sp)
                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {

                    Icon(
                        painter = painterResource(R.drawable.notification_icon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

            }

            SearchBar(query = searchText, onSearch = {}, onQueryChanged = { searchText = it })


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
                    RecipeCard(recipe = filteredRecipes[index])
                }
            }

            //categories section
            CategoriesRow(categories)


        }


    }


}