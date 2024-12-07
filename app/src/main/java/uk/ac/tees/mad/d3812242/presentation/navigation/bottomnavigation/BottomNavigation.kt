package uk.ac.tees.mad.d3812242.presentation.navigation.bottomnavigation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.ac.tees.mad.d3812242.R

sealed class BottomNavItem(val label: String, val icon: Int) {
    data object Home : BottomNavItem("Home", R.drawable.home)
    data object Search : BottomNavItem("Search", R.drawable.search)
    data object Saved : BottomNavItem("Saved",R.drawable.bookmark)
    data object Profile : BottomNavItem("Profile", R.drawable.profile)
}

@Composable
fun BottomNavigationBar(
    selectedTab: String,
    onTabSelected: (String) -> Unit
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Saved,
        BottomNavItem.Profile
    )

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        items.forEach { item ->
            val isSelected = item.label == selectedTab
            NavigationBarItem(
                selected = isSelected,
                onClick = { onTabSelected(item.label) },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.label,
                        tint = if (isSelected) Color(0xFFFFA500) else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (isSelected) Color(0xFFFFA500) else Color.Gray
                    )
                }
            )
        }
    }
}

@Composable
fun MainScreenWithNavigation() {
    var selectedTab by remember { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { paddingValues ->
        // Main screen content goes here
        Text(
            text = "Selected Tab: $selectedTab",
            modifier = Modifier.padding(paddingValues).padding(16.dp),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMainScreenWithNavigation() {
    MainScreenWithNavigation()
}
