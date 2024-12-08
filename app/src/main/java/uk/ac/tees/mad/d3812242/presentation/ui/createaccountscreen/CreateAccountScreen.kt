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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.layout.ContentScale
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
fun CreateAccountScreen(
    navController: NavController,
    signUpScreenViewModel: SignUpScreenViewModel,
    loginScreenViewModel: LoginScreenViewModel
) {
    val poppinsFontFamily =
        FontFamily(Font(resId = R.font.poppins_semibold, weight = FontWeight.Bold))

    var email by remember { mutableStateOf("") }
    var isSubmitted by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Header Image and Navigation Row
        Box {
            Image(
                painter = painterResource(id = R.drawable.imgofcreateacc),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f) // Maintain a responsive aspect ratio
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Log In",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.clickable { navController.navigate(Routes.LoginScreen) },
                    fontFamily = poppinsFontFamily
                )
            }
        }

        // Title Text
        Text(
            text = "Let's start making good meals",
            fontSize = 23.sp,
            color = colorResource(id = R.color.amberOrange),
            fontFamily = poppinsFontFamily,
            modifier = Modifier.padding(16.dp)
        )

        // Input Fields
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            // Username Field
            TextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text(text = "User Name", fontSize = 14.sp, fontFamily = poppinsFontFamily) },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = colorResource(id = R.color.amberOrange),
                    focusedIndicatorColor = colorResource(id = R.color.amberOrange),
                    focusedContainerColor =  Color.White,
                    unfocusedContainerColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )
            if (isSubmitted && username.isEmpty()) {
                Text(
                    text = "Please enter your User name",
                    color = Color.Red,
                    fontFamily = poppinsFontFamily,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Email Field
            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "Your Email", fontSize = 14.sp, fontFamily = poppinsFontFamily) },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = colorResource(id = R.color.amberOrange),
                    focusedIndicatorColor = colorResource(id = R.color.amberOrange),
                    focusedContainerColor =  Color.White,
                    unfocusedContainerColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )
            if (isSubmitted && email.isEmpty()) {
                Text(
                    text = "Please enter your Email",
                    color = Color.Red,
                    fontFamily = poppinsFontFamily,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "Password", fontSize = 14.sp, fontFamily = poppinsFontFamily) },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = colorResource(id = R.color.amberOrange),
                    focusedIndicatorColor = colorResource(id = R.color.amberOrange),
                    focusedContainerColor =  Color.White,
                    unfocusedContainerColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )
            if (isSubmitted && password.isEmpty()) {
                Text(
                    text = "Please enter Password",
                    color = Color.Red,
                    fontFamily = poppinsFontFamily,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons and Divider
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Create Account Button
            Button(
                onClick = {
                    isSubmitted = true
                    if (isUsernameValid(username) && isEmailValid(email) && isPasswordValid(password)) {
                        signUpScreenViewModel.signUpUser(username, email, password)
                        if (signUpScreenViewModel.isSignedUp.value) {
                            navController.navigate(Routes.HomeScreen)
                        } else {
                            Toast.makeText(context, signUpScreenViewModel.errorMessage, Toast.LENGTH_LONG).show()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.black),
                    containerColor = colorResource(id = R.color.amberOrange)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Create Account", fontFamily = poppinsFontFamily)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Divider
            Row(verticalAlignment = Alignment.CenterVertically) {
                Divider(modifier = Modifier.weight(1f), color = Color.Black, thickness = 1.dp)
                Text(text = "OR", modifier = Modifier.padding(horizontal = 8.dp), fontFamily = poppinsFontFamily)
                Divider(modifier = Modifier.weight(1f), color = Color.Black, thickness = 1.dp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Social Sign-Up Buttons
            Button(
                onClick = { /* Facebook Sign-Up Logic */ },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.black),
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Sign Up with Facebook", fontSize = 14.sp, fontFamily = poppinsFontFamily)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { loginScreenViewModel.startSignIn() },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.black),
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Sign Up with Google", fontSize = 14.sp, fontFamily = poppinsFontFamily)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Terms of Use and Privacy Policy", fontSize = 12.sp, fontFamily = poppinsFontFamily)
        }
    }
}
// Validation functions
fun isUsernameValid(username: String): Boolean {
    return username.isNotEmpty()
}

fun isEmailValid(email: String): Boolean {
    val emailRegex = Regex(pattern = "[^@]+@[^.]+\\..+")
    return emailRegex.matches(email)
}

fun isPasswordValid(password: String): Boolean {
    return password.length >= 6
}