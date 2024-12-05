package uk.ac.tees.mad.d3812242.presentation.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.ac.tees.mad.d3812242.R

@Composable
@Preview(showBackground = true)
fun SplashScreen(){
Column (modifier = Modifier
    .fillMaxSize()
    .background(color = (colorResource(id = R.color.vividOrange)))
    , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){

        Image(painter = painterResource(id = R.drawable.logo), contentDescription =null, modifier = Modifier.size(95.dp,95.dp))
    Text(text = "Cook Book", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)



}
}