package uk.ac.tees.mad.d3812242.presentation.ui.homescreen.recipecard

import androidx.compose.foundation.Image
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
import uk.ac.tees.mad.d3812242.R

data class Recipe(val name: String, val category: String, val imageRes: Int)

val recipes = listOf(
    Recipe("Spiced Fried Chicken", "Chili chicken", R.drawable.fried_chicken_rice_img),
    Recipe("spicy chicken", "Chili chicken", R.drawable.chili_chicken_img),

    Recipe("Crispy Tofu Delight", "Crispy tofu", R.drawable.crispy_tofu_img),
    Recipe("Crispy Tofu Stick", "Crispy tofu", R.drawable.crispy_tofu_stick_img),

    Recipe("Golden Fried Fish", "Fried fish", R.drawable.fried_fish),

    Recipe("Traditional Sunday Roast", "Roast", R.drawable.sunday_roast),
    Recipe("All-Time Favorite Chicken", "All", R.drawable.fried_chicken_rice_img)
)

@Composable
fun RecipeCard(recipe: Recipe) {

    var isBookMarkClicked by remember {
        mutableStateOf(false)
    }
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(290.dp),
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

                    if (isBookMarkClicked){
                        Icon(
                            painter = painterResource(R.drawable.bookmark_filled),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(18.dp),
                            tint = colorResource(R.color.orange)
                        )


                    }else {
                        Icon(
                            painter = painterResource(R.drawable.bookmark_outlined),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(18.dp)
                                .clickable { isBookMarkClicked = true })
                    }
                }
            }
        }
    }
}
