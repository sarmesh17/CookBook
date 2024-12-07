package uk.ac.tees.mad.d3812242.presentation.ui.createaccountscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.navigation.Routes
import uk.ac.tees.mad.d3812242.viewmodels.LoginScreenViewModel
import uk.ac.tees.mad.d3812242.viewmodels.SignUpScreenViewModel

@Composable
fun CreateAccountScreen(navController: NavController,signUpScreenViewModel: SignUpScreenViewModel,loginScreenViewModel: LoginScreenViewModel) {
    val poppinsFontFamily =
        FontFamily(Font(resId = R.font.poppins_semibold, weight = FontWeight.Bold))
    var email by remember {
        androidx.compose.runtime.mutableStateOf("")

    }
    var isSubmitted by remember {
        mutableStateOf(false)
    }
    var password by remember {
        androidx.compose.runtime.mutableStateOf("")

    }
    var uesrname by remember {
        androidx.compose.runtime.mutableStateOf("")

    }

    val context= LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.imgofcreateacc),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, end = 10.dp, start = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = null, tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Log In",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.clickable { navController.navigate(Routes.LoginScreen) },
                    fontFamily = poppinsFontFamily
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 15.dp)
        ) {
            Text(
                text = "Let's start making good meals",
                fontSize = 40.sp,
                color = colorResource(id = R.color.amberOrange),
                fontFamily = poppinsFontFamily
            )

        }
        Column {

            TextField(value = uesrname,
                onValueChange = { uesrname = it },
                placeholder = { Text(text = "User Name", fontSize = 15.sp, fontFamily = poppinsFontFamily) },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = colorResource(
                        id = R.color.amberOrange
                    ), focusedIndicatorColor = colorResource(id = R.color.amberOrange),
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp, start = 25.dp, end = 25.dp)
            )
            if (isSubmitted && email.isEmpty()) {
                Text(
                    text = "Please enter your User name",
                    color = Color.Red, fontFamily = poppinsFontFamily,
                    modifier = Modifier.padding(start = 25.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "Your Email", fontSize = 15.sp, fontFamily = poppinsFontFamily) },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = colorResource(
                        id = R.color.amberOrange
                    ), focusedIndicatorColor = colorResource(id = R.color.amberOrange),
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp, start = 25.dp, end = 25.dp)
            )
            if (isSubmitted && email.isEmpty()) {
                Text(
                    text = "Please enter your Email",
                    color = Color.Red, fontFamily = poppinsFontFamily,
                    modifier = Modifier.padding(start = 25.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "Password", fontSize = 15.sp, fontFamily = poppinsFontFamily) },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = colorResource(
                        id = R.color.amberOrange
                    ), focusedIndicatorColor = colorResource(id = R.color.amberOrange),
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp, start = 25.dp, end = 25.dp)
            )
            if (isSubmitted && email.isEmpty()) {
                Text(
                    text = "Please enter Password",
                    color = Color.Red, fontFamily = poppinsFontFamily,
                    modifier = Modifier.padding(start = 25.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Button(
                onClick = { isSubmitted = true
                    signUpScreenViewModel.signUpUser(uesrname,email,password)
                    if (signUpScreenViewModel.isSignedUp.value == true) {
                        Log.d("signUpScreen success", "state: ${signUpScreenViewModel.isSignedUp.value}")
                        navController.navigate(Routes.HomeScreen)
                    } else {
                        Log.d("signUpScreen failed", "state: ${signUpScreenViewModel.isSignedUp.value}")
                        Toast.makeText(context, signUpScreenViewModel.errorMessage, Toast.LENGTH_LONG).show()
                    }
                },
                modifier = Modifier.size(234.dp, 40.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(
                        id = R.color.black
                    ), containerColor = colorResource(id = R.color.amberOrange)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Create Account", fontFamily = poppinsFontFamily)
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                HorizontalDivider(
                    thickness = 1.5.dp, color = Color.Black, modifier = Modifier
                        .width(80.dp)
                        .padding(top = 8.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "OR")
                Spacer(modifier = Modifier.width(8.dp))

                HorizontalDivider(
                    thickness = 1.5.dp, color = Color.Black, modifier = Modifier
                        .width(80.dp)
                        .padding(top = 8.dp)
                )

            }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(234.dp, 40.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(
                        id = R.color.black
                    ), containerColor = colorResource(id = R.color.white)
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(width = 1.dp, color = Color.Black)
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Sign Up with Facebook", fontSize = 15.sp, fontFamily = poppinsFontFamily)

                }

            }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    loginScreenViewModel.startSignIn();
                },
                modifier = Modifier.size(234.dp, 40.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(
                        id = R.color.black
                    ), containerColor = colorResource(id = R.color.white)
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(width = 1.dp, color = Color.Black)
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Sign Up with Google", fontSize = 15.sp, fontFamily = poppinsFontFamily)

                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Term of Use and Privacy Policy", fontSize = 13.sp, fontFamily = poppinsFontFamily)
        }


    }
}