package uk.ac.tees.mad.d3812242.presentation.ui.searchhistoryscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.navigation.Routes
import uk.ac.tees.mad.d3812242.presentation.navigation.bottomnavigation.BottomNavigationBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UKFoodSearchHistoryScreen(navHostController: NavHostController) {
    // Search History Data with Corresponding Images
    val searchHistory = listOf(
        Triple("Fish and Chips", "2 days ago", R.drawable.fish_and_chips_img),
        Triple("Shepherd's Pie", "5 days ago", R.drawable.shepherds_pie_img),
        Triple("Full English Breakfast", "12 Nov 2023", R.drawable.full_english_breakfast_img)
    )

    // Last Viewed Data with Corresponding Images
    val lastViewed = listOf(
        Triple("Yorkshire Pudding", 4.5f, R.drawable.yorkshire_pudding_img),
        Triple("Cornish Pasty", 4.3f, R.drawable.cornish_pasty_img),
        Triple("Victoria Sponge Cake", 4.8f, R.drawable.victoria_sponge_cake_img)
    )

    // Search History Data with Corresponding Images
    val allRecipes = listOf(
        Recipe("Fish and Chips", "2 days ago", R.drawable.fish_and_chips_img),
        Recipe("Shepherd's Pie", "5 days ago", R.drawable.shepherds_pie_img),
        Recipe("Full English Breakfast", "12 Nov 2023", R.drawable.full_english_breakfast_img),
        Recipe("Yorkshire Pudding", "4.5 Rating", R.drawable.yorkshire_pudding_img),
        Recipe("Cornish Pasty", "4.3 Rating", R.drawable.cornish_pasty_img),
        Recipe("Victoria Sponge Cake", "4.8 Rating", R.drawable.victoria_sponge_cake_img),
        Recipe("Spiced Fried Chicken", "Chili chicken", R.drawable.fried_chicken_rice_img),
        Recipe("Spicy Chicken", "Chili chicken", R.drawable.chili_chicken_img),
        Recipe("Crispy Tofu Delight", "Crispy tofu", R.drawable.crispy_tofu_img),
        Recipe("Crispy Tofu Stick", "Crispy tofu", R.drawable.crispy_tofu_stick_img),
        Recipe("Golden Fried Fish", "Fried fish", R.drawable.fried_fish),
        Recipe("Traditional Sunday Roast", "Roast", R.drawable.sunday_roast),
        Recipe("All-Time Favorite Chicken", "All", R.drawable.fried_chicken_rice_img)
    )

    // State to hold search query and filtered list
    var searchQuery by remember { mutableStateOf("") }
    val filteredDishes = if (searchQuery.isEmpty()) allRecipes else {
        allRecipes.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    val poppinsFontFamily = FontFamily(

        Font(resId = R.font.poppins_semibold)
    )
    var selectedTab by remember { mutableStateOf("Search") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Search Recipes", fontFamily = poppinsFontFamily) },
                colors = TopAppBarDefaults.topAppBarColors(), navigationIcon = { Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = null, modifier = Modifier.size(32.dp).clickable{navHostController.navigateUp()}) }
            )
        }, bottomBar = {
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
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Search Bar
            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = {searchQuery=it},
                    placeholder = { Text("Type Recipes...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = colorResource(R.color.culturedWhite))
                )
            }

            // Search History Section
            item {
                SectionHeader(
                    title = if (searchQuery.isEmpty()) "Search history" else "Search results",
                    onSeeAllClick = { /* Handle See All */ }
                )
            }
            items(filteredDishes.take(4)) { (title, date, imageRes) ->
                ListItem(
                    headlineContent = { Text(title) },
                    supportingContent = { Text(date) },
                    leadingContent = {
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = "Dish Image",
                            modifier = Modifier.size(56.dp).clip(RoundedCornerShape(12.dp)), contentScale = ContentScale.Crop
                        )
                    },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            // Last Viewed Section
            item {
                SectionHeader(
                    title = "Last viewed",
                    onSeeAllClick = { /* Handle See All */ }
                )
            }
            item {
                LazyRow(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(lastViewed) { (title, rating, imageRes) ->
                        Card(
                            modifier = Modifier
                                .size(150.dp)
                                .clickable { /* Handle click */ },
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Column {
                                Image(
                                    painter = painterResource(id = imageRes),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                                Text(
                                    text = "⭐ $rating",
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SectionHeader(title: String, onSeeAllClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = MaterialTheme.typography.titleMedium)
        TextButton(onClick = onSeeAllClick) {
            Text("See All")
        }
    }
}

data class Recipe(
    val name: String,
    val subtitle: String,
    val imageRes: Int
)