package uk.ac.tees.mad.d3812242.presentation.ui.loginscreen

import android.app.Activity.RESULT_OK
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.navigation.NavHostController
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.navigation.Routes
import uk.ac.tees.mad.d3812242.viewmodels.LoginScreenViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.layout.ContentScale

@Composable
fun LoginScreen(navController: NavController, loginScreenViewModel: LoginScreenViewModel) {
    val poppinsFontFamily = FontFamily(
        Font(resId = R.font.poppins, weight = FontWeight.Bold)
    )

    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }

    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    val intentSender by loginScreenViewModel.intentSenderLiveData.observeAsState()
    val loginSuccess by loginScreenViewModel.loginSuccessLiveData.observeAsState()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            loginScreenViewModel.handleSignInResult(result.data)
        }
    }

    LaunchedEffect(intentSender) {
        intentSender?.let {
            launcher.launch(IntentSenderRequest.Builder(it).build())
        }
    }

    LaunchedEffect(loginSuccess) {
        if (loginSuccess == true) {
            loginScreenViewModel.updateLoginState(context, true)
            navController.navigate(Routes.HomeScreen) {
                popUpTo(Routes.LoginScreen) { inclusive = true }
            }
        }
    }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.loginscreen),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16 / 9f)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.vector1),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { navController.popBackStack() }
                    )
                    Text(
                        text = "Sign Up",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier.clickable { navController.navigate(Routes.SignUpScreen) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Welcome Back to Good Food",
                fontSize = 25.sp,
                fontFamily = poppinsFontFamily,
                color = colorResource(id = R.color.amberOrange),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                // Email Field
                TextField(
                    value = email,
                    onValueChange = {
                        email = it
                        emailError = if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) null else "Invalid email format"
                    },
                    placeholder = {
                        Text(
                            text = "Your Email",
                            fontSize = 14.sp,
                            fontFamily = poppinsFontFamily
                        )
                    },
                    isError = emailError != null,
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = colorResource(id = R.color.amberOrange),
                        focusedIndicatorColor = colorResource(id = R.color.amberOrange),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                emailError?.let {
                    Text(text = it, color = Color.Red, fontSize = 12.sp, modifier = Modifier.padding(start = 8.dp))
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Password Field
                TextField(
                    value = password,
                    onValueChange = {
                        password = it
                        passwordError = if (password.length >= 6) null else "Password must be at least 6 characters"
                    },
                    placeholder = {
                        Text(
                            text = "Password",
                            fontSize = 14.sp,
                            fontFamily = poppinsFontFamily
                        )
                    },
                    isError = passwordError != null,
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = colorResource(id = R.color.amberOrange),
                        focusedIndicatorColor = colorResource(id = R.color.amberOrange),
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                passwordError?.let {
                    Text(text = it, color = Color.Red, fontSize = 12.sp, modifier = Modifier.padding(start = 8.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Switch(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = colorResource(id = R.color.amberOrange),
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = colorResource(id = R.color.amberOrange)
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Remember", fontFamily = poppinsFontFamily)
                }
                Text(text = "Forget ?", fontFamily = poppinsFontFamily)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        if (email.isBlank()) {
                            emailError = "Email cannot be empty"
                        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                            emailError = "Invalid email format"
                        } else {
                            emailError = null
                        }

                        if (password.isBlank()) {
                            passwordError = "Password cannot be empty"
                        } else if (password.length < 6) {
                            passwordError = "Password must be at least 6 characters"
                        } else {
                            passwordError = null
                        }

                        if (emailError == null && passwordError == null) {
                            loginScreenViewModel.signInUser(email, password) { isSuccess, error ->
                                if (isSuccess) {
                                    navController.navigate(Routes.HomeScreen)
                                } else {
                                    Toast.makeText(context, error ?: "Login failed", Toast.LENGTH_LONG).show()
                                }
                            }
                        } else {
                            Toast.makeText(context, "Please fix the errors", Toast.LENGTH_LONG).show()
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
                    Text(text = "Log In", fontFamily = poppinsFontFamily)
                }
            }
        }
    }
}
