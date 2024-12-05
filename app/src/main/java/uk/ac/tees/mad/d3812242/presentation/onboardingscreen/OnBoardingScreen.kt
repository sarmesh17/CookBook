package uk.ac.tees.mad.d3812242.presentation.onboardingscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.ac.tees.mad.d3812242.R

@Composable
@Preview(showBackground = true)
fun OnBoardingScreen(){
Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 15.dp, end = 20.dp), horizontalArrangement = Arrangement.End){
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = colorResource(
            id = R.color.culturedWhite
        ), contentColor = Color.Gray), shape = RoundedCornerShape(8.dp), modifier = Modifier.size(75.dp,38.dp)) {
            Text(text = "Skip", fontSize = 10.sp)
            
        }
    }
    Spacer(modifier = Modifier.height(200.dp))
    Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.illustration), contentDescription =null, modifier = Modifier.size(260.dp,164.dp) )

    }
    Spacer(modifier = Modifier.height(25.dp))
    Column (modifier = Modifier.padding(all = 30.dp), horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Thousands of tested recipes", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "There is no need to fear failure. Tested recipes are guaranteed to work by our professional chefs.", fontSize = 14.sp, color = Color.Gray)

    }
    Spacer(modifier = Modifier.height(120.dp))
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(color = Color.LightGray)

            )
            Spacer(modifier = Modifier.width(4.dp))
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(color = Color.LightGray)
            )
            Spacer(modifier = Modifier.width(4.dp))

            Box(
                modifier = Modifier
                    .size(24.dp, 8.dp)
                    .background(
                        color = colorResource(id = R.color.amberOrange),
                        shape = RoundedCornerShape(4.dp)
                    )
            )
        }
    Spacer(modifier = Modifier.height(35.dp))
    Button(onClick = { }, colors = ButtonDefaults.buttonColors(containerColor = colorResource(
        id = R.color.amberOrange), contentColor = colorResource(id = R.color.white)), modifier = Modifier.size(width = 327.dp, height = 52.dp), shape = RoundedCornerShape(6.dp)
    ) {
        Text(text = "Get Start", fontSize = 14.sp, fontWeight = FontWeight.Medium)

    }
    }



}
