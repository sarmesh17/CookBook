package uk.ac.tees.mad.d3812242.presentation.ui.bookmarkscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uk.ac.tees.mad.d3812242.presentation.navigation.Routes
import uk.ac.tees.mad.d3812242.presentation.navigation.bottomnavigation.BottomNavigationBar
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard.RecipeCard
import uk.ac.tees.mad.d3812242.presentation.viewmodels.RecipeViewModel

@Composable
fun BookmarkScreen(viewModel: RecipeViewModel,navHostController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }

    // Filter bookmarked recipes based on the search query
    val filteredRecipes = viewModel.bookmarkedRecipes.filter { recipe ->
        recipe.name.contains(searchQuery, ignoreCase = true)
    }

    var selectedTab by remember { mutableStateOf("Saved") }

    Scaffold( bottomBar = {
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
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Heading: Recipe Saved
            Text(
                text = "Recipe saved",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp),
                color = MaterialTheme.colorScheme.onBackground
            )

            // Search Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .background(
                        color = Color.LightGray.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .height(48.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Search Icon
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    // Search Text Field
                    BasicTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        decorationBox = { innerTextField ->
                            if (searchQuery.isEmpty()) {
                                Text(
                                    text = "Search saved recipes...",
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                            }
                            innerTextField()
                        }
                    )
                }
            }

            // Content: Check if filtered recipes are empty
            if (filteredRecipes.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "No recipes found!",
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 20.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                // Recipe Grid
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(filteredRecipes) { recipe ->
                        RecipeCard(
                            recipe = recipe,
                            viewModel = viewModel,navHostController
                        )
                    }
                }
            }
        }
    }
}
