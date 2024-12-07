package uk.ac.tees.mad.d3812242.presentation.ui.homescreen.searchbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uk.ac.tees.mad.d3812242.presentation.navigation.Routes


@Composable
fun SearchBar(
    navHostController: NavHostController
) {
    Surface(
        modifier = Modifier.fillMaxWidth()
            .padding( vertical = 4.dp, horizontal = 16.dp).clickable { navHostController.navigate(Routes.SearchScreen) },
        color = Color.White,
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp
    ) {


        Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text field

        Box(

            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(color = Color(0xFFF3F4F6)), contentAlignment = Alignment.CenterStart
        ) {

            Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp), horizontalArrangement = Arrangement.SpaceBetween){


                Text(text = "Type ingredients...", color = Color(0xFF9CA3AF))

                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color(0xFF9CA3AF)// Color of the search icon
                )


            }




        }


    }
}




