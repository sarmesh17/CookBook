package uk.ac.tees.mad.d3812242.presentation.ui.splashscreen

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.data.localmanager.DataStoreManager
import uk.ac.tees.mad.d3812242.presentation.navigation.Routes


@Composable
fun SplashScreen(navController: NavController, dataStoreManager: DataStoreManager) {

    val poppinsFontFamily = FontFamily(
        Font(resId = R.font.poppins_semibold, weight = FontWeight.Bold)
    )

    LaunchedEffect(Unit) {
        val isOnboardingCompleted = dataStoreManager.isOnboardingCompleted()
        val isUserLoggedIn = dataStoreManager.isUserLoggedIn()

        when {
            !isOnboardingCompleted -> {
                navController.navigate(Routes.OnBoardingScreen) {
                    popUpTo(Routes.SplashScreen) { inclusive = true }
                }
            }
            !isUserLoggedIn -> {
                navController.navigate(Routes.LoginScreen) {
                    popUpTo(Routes.SplashScreen) { inclusive = true }
                }
            }
            else -> {
                navController.navigate(Routes.HomeScreen) {
                    popUpTo(Routes.SplashScreen) { inclusive = true }
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = (colorResource(id = R.color.vividOrange))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(100.dp, 100.dp)
        )

        Text(
            text = "Cook Book",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontFamily = poppinsFontFamily
        )
    }
}
