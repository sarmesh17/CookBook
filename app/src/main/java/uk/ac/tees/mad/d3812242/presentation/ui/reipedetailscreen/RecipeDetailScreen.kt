package uk.ac.tees.mad.d3812242.presentation.ui.reipedetailscreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.toRoute
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.navigation.Routes

@Composable
fun RecipeDetailScreenWithAnimation(recipe: NavBackStackEntry) {

    val poppinsFontFamily = FontFamily(

        Font(resId = R.font.poppins_semibold)
    )

    val args=recipe.toRoute<Routes.RecipeDetailScreen>()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Image Section
        item {
            Image(
                painter = painterResource(id = args.imageRes),
                contentDescription = "Image",
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
                    text = args.name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground, fontFamily = poppinsFontFamily
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "⭐ ${args.rating}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
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
                        text = args.description,
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
                    args.ingredients.forEach {
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
                    args.steps.forEachIndexed { index, step ->
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


