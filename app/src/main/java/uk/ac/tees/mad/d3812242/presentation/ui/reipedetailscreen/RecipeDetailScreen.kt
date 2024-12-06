package uk.ac.tees.mad.d3812242.presentation.ui.reipedetailscreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.ac.tees.mad.d3812242.R

@Composable
fun RecipeDetailScreenWithAnimation(recipe: Recipe, onFollowClick: () -> Unit = {}) {

    val poppinsFontFamily = FontFamily(

        Font(resId = R.font.poppins_semibold)
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Image Section
        item {
            Image(
                painter = painterResource(id = recipe.imageResId),
                contentDescription = "${recipe.title} Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Title and Rating
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground, fontFamily = poppinsFontFamily
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "⭐ ${recipe.rating}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        // User Info Section
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = recipe.userAvatarResId),
                    contentDescription = "${recipe.userName} Avatar",
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(50)
                        )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = recipe.userName,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground, fontFamily = poppinsFontFamily
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    ClickableText(
                        text = AnnotatedString(recipe.userHandle),
                        style = MaterialTheme.typography.bodySmall.copy(
                            textDecoration = TextDecoration.Underline,
                            color = Color.Gray
                        ),
                        onClick = { /* Handle user profile click */ }
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = onFollowClick, colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.orange))) {
                    Text("Follow")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Description Section with Animation
        item {
            AnimateOnScroll {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground, fontFamily = poppinsFontFamily
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = recipe.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray, fontFamily = poppinsFontFamily,
                        fontSize = 14.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Ingredients Section with Animation
        item {
            AnimateOnScroll {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Ingredients",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground, fontFamily = poppinsFontFamily
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    recipe.ingredients.forEach {
                        Text(
                            text = "• $it",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray, fontFamily = poppinsFontFamily,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Cooking Steps Section with Animation
        item {
            AnimateOnScroll {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Cooking Steps",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground, fontFamily = poppinsFontFamily
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    recipe.steps.forEachIndexed { index, step ->
                        Text(
                            text = "${index + 1}. $step",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray, fontFamily = poppinsFontFamily,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun AnimateOnScroll(content: @Composable () -> Unit) {
    val offsetX = remember { Animatable(-300f) } // Initial position off-screen
    LaunchedEffect(Unit) {
        offsetX.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
        )
    }

    Box(
        modifier = Modifier
            .offset(x = offsetX.value.dp) // Moves content from left
    ) {
        content()
    }
}

data class Recipe(
    val title: String,
    val imageResId: Int,
    val userAvatarResId: Int,
    val userName: String,
    val userHandle: String,
    val rating: String,
    val description: String,
    val ingredients: List<String>,
    val steps: List<String> // Added for cooking steps
)

@Preview(showBackground = true)
@Composable
fun PreviewRecipeDetailScreen() {
    // Sample Recipe Data
    val sampleRecipe = Recipe(
        title = "Spiced Fried Chicken",
        imageResId = R.drawable.chicken_img, // Replace with your drawable resource
        userAvatarResId = R.drawable.ashish_chanchlani, // Replace with your drawable resource
        userName = "Yumna Azzahra",
        userHandle = "@yumnaazzahra01",
        rating = 4.5.toString(),
        description = "Spiced Fried Chicken or Ayam Goreng, is a delicious and popular dish that showcases the vibrant flavors of Indonesian cuisine.",
        ingredients = listOf(
            "200 grams of egg noodles, boiled until tender",
            "6 tbsp onion chicken oil",
            "3 tsp soy sauce",
            "2 bunches of mustard greens, blanched",
            "250 grams chicken meat, diced",
            "6 pieces of boiled feet"
        ),
        steps = listOf(
            "Boil the egg noodles until tender, then drain.",
            "Blanch the mustard greens in boiling water.",
            "Heat onion chicken oil in a pan and sauté the chicken meat.",
            "Add soy sauce and mix well.",
            "Serve noodles with chicken, mustard greens, and boiled feet."
        )
    )

    RecipeDetailScreenWithAnimation(recipe = sampleRecipe, onFollowClick = { /* Follow action */ })
}
