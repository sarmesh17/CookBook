package uk.ac.tees.mad.d3812242.presentation.ui.homescreen.scrollabletextbutton

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import uk.ac.tees.mad.d3812242.R

@Composable
fun ScrollableTextButtonsRow(
    selectedCategory: String,
    onCategorySelected: (String) -> Unit // Callback to update selected category
) {
    val scrollState = rememberScrollState()
    val buttonTexts = listOf("All", "Chili chicken", "Crispy tofu", "Fried fish", "Roast")

    val poppinsFontFamily = FontFamily(Font(resId = R.font.poppins_semibold, weight = FontWeight.Bold))

    androidx.compose.foundation.layout.Row(
        modifier = Modifier.horizontalScroll(scrollState) // Enables horizontal scrolling
    ) {
        buttonTexts.forEach { text ->
            TextButton(
                onClick = {
                    onCategorySelected(text) // Update selected category when clicked
                }
            ) {
                Text(
                    text = text,
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp,
                    color = if (text == selectedCategory) Color.Black else Color.Gray // Black for selected, Gray for others
                )
            }
        }
    }
}
