package uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.navigation.Routes
import uk.ac.tees.mad.d3812242.presentation.viewmodels.RecipeViewModel

data class Recipe(
    val name: String,
    val description: String,
    val imageRes: Int,
    val rating: String,
    val ingredients: List<String>,
    val steps: List<String>,
    val category: String // Add this line

)

// Updated Recipe list with additional data


@Composable
fun RecipeCard(recipe: Recipe, viewModel: RecipeViewModel, navHostController: NavHostController) {

    var isBookmarked by remember {
        mutableStateOf(false)
    }
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(290.dp)
            .clickable {
                navHostController.navigate(
                    Routes.RecipeDetailScreen(
                        name = recipe.name,
                        description = recipe.description,
                        imageRes = recipe.imageRes,
                        rating = recipe.rating,
                        ingredients = recipe.ingredients,
                        steps = recipe.steps
                    )
                )
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(recipe.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = recipe.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 4.dp)
            ) {
                Icon(Icons.Filled.Star, contentDescription = "Rating", tint = Color(0xFFFFD700))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "(4.5)", fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "30 min", fontSize = 12.sp, color = Color.Gray)

                Box(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        painter = painterResource(
                            if (isBookmarked) R.drawable.bookmark_filled
                            else R.drawable.bookmark_outlined
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(18.dp)
                            .clickable {
                                viewModel.toggleBookmark(recipe)
                                isBookmarked = !isBookmarked
                            },
                        tint = if (isBookmarked) colorResource(R.color.orange) else Color.Gray
                    )
                }
            }
        }
    }
}
