package uk.ac.tees.mad.d3812242.presentation.ui.homescreen.categoriesrow

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.navigation.Routes

@Composable
fun CategoriesRow(categories: List<Category>, navHostController: NavHostController) {

    val poppinsFontFamily = FontFamily(
        Font(resId = R.font.poppins_semibold)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Categories",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp), fontFamily = poppinsFontFamily
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(categories) { category ->
                CategoryCard(category.title, category.imageRes, navHostController)

            }
        }
    }
}

@Composable
fun CategoryCard(title: String, imageRes: Int, navHostController: NavHostController) {
    val imageOffsetY = remember { Animatable(0f) }
    val textOffsetY = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .width(100.dp)
            .height(120.dp)
            .clickable {
                scope.launch {
                    // Animate the image to move up
                    launch {
                        imageOffsetY.animateTo(
                            targetValue = -200f, // Move image up
                            animationSpec = tween(durationMillis = 500)
                        )
                    }
                    // Animate the text to move down
                    launch {
                        textOffsetY.animateTo(
                            targetValue = 200f, // Move text down
                            animationSpec = tween(durationMillis = 500)
                        )
                    }

                    if (title == "Vegetarian") {
                        navHostController.navigate(Routes.VegListScreen)
                    } else if (title == "Beef") {

                        navHostController.navigate(Routes.BeefListScreen)
                    } else if (title == "Chicken") {

                        navHostController.navigate(Routes.ChickenScreenList)
                    }
                }
            },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = title,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .offset(y = Dp(imageOffsetY.value)), // Apply vertical offset animation to image
            )
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .offset(y = Dp(textOffsetY.value)), // Apply vertical offset animation to text
                textAlign = TextAlign.Center
            )
        }
    }
}


// Category data class remains the same
data class Category(val title: String, val imageRes: Int)
