package uk.ac.tees.mad.d3812242.presentation.ui.homescreen.foodselectionButtons

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import uk.ac.tees.mad.d3812242.R

@Composable
fun HorizontalScrollable(items: List<String>) {
    val selectedItem = remember { mutableStateOf(items.firstOrNull()) }


    // Horizontal scrolling container
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()) // Allow horizontal scrolling
            .padding(horizontal = 8.dp)
    ) {
        // Wrapping rows using FlowRow
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            mainAxisSpacing = 8.dp, // Space between buttons horizontally
            crossAxisSpacing = 8.dp, // Space between rows vertically
        ) {
            items.forEach { item ->
                FoodButtonMaterial3(
                    text = item,
                    isSelected = selectedItem.value == item,
                    onClick = { selectedItem.value = item }
                )
            }
        }
    }
}

@Composable
fun FoodButtonMaterial3(text: String, isSelected: Boolean, onClick: () -> Unit) {

    val poppinsFontFamily = FontFamily(

        Font(resId = R.font.poppins_semibold, weight = FontWeight.Bold)
    )
    ElevatedButton(
        onClick = onClick,
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = if (isSelected) colorResource(R.color.orange) else MaterialTheme.colorScheme.surface,
            contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(horizontal = 4.dp) // Padding between buttons
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 8.dp), fontFamily =poppinsFontFamily
        )
    }
}
