package uk.ac.tees.mad.d3812242.presentation.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.ac.tees.mad.d3812242.R

@Composable
@Preview(showSystemUi = true)
fun HomeScreen() {

    Scaffold {
        Column(modifier = Modifier.padding(it)) {

            Row(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ashish_chanchlani),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp).clip(CircleShape)
                )

                Spacer(Modifier.width(16.dp))

                Column {
                    // Greeting
                    Text("Welcome, \uD83D\uDC4B\uD83C\uDFFB", fontSize = 14.sp, lineHeight = 18.sp, color = Color(0xFF9CA3AF))

                    Spacer(modifier = Modifier.height(4.dp))
                    // name
                    Text("Ashish Chanchalani", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){

                    Icon(painter = painterResource(R.drawable.notification_icon), contentDescription = null, modifier = Modifier.size(24.dp))
                }



            }


        }
    }


}