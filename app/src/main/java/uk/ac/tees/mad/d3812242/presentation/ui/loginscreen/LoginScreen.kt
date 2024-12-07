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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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


@Composable
fun LoginScreen(navController: NavController, loginScreenViewModel: LoginScreenViewModel){
    var poppinsFontFamily = FontFamily(
        Font(resId =R.font.poppins,weight =FontWeight.Bold)
    )

    val context = LocalContext.current


    var email by remember {
        androidx.compose.runtime.mutableStateOf("")

    }

    var password by remember {
        mutableStateOf("")
    }


    var isChecked by remember {
        mutableStateOf(false)
    }





    val intentSender by loginScreenViewModel.intentSenderLiveData.observeAsState()
    val loginSuccess by loginScreenViewModel.loginSuccessLiveData.observeAsState()
    val error by loginScreenViewModel.errorLiveData.observeAsState()

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartIntentSenderForResult()) { result->

            if (result.resultCode == RESULT_OK){
                loginScreenViewModel.handleSignInResult(result.data)
            } else {
                Log.e("SignInFailure","Sign-in failed with resultCode: ${result.resultCode}")
                result.data?.let {
                    val errorMessage = it.getStringExtra("error_message")
                    Log.e("SignInFailure", "Error Message: $errorMessage")
                }
            }
        }

    LaunchedEffect(intentSender) {
        intentSender?.let{
            launcher.launch(IntentSenderRequest.Builder(it).build())
        }
    }

    LaunchedEffect(loginSuccess) {
        if (loginSuccess == true) {
            navController.navigate(Routes.HomeScreen)
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.loginscreen),
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
                    painter = painterResource(id = R.drawable.vector1),
                    contentDescription = null, tint = Color.White,
                    modifier = Modifier.size(20.dp).clickable { navController.popBackStack() }
                )
                Text(text = "Sign Up", fontSize = 20.sp, color = Color.White, fontFamily = poppinsFontFamily, modifier = Modifier.clickable { navController.navigate(Routes.SignUpScreen) })
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 15.dp)
        ) {
            Text(
                text = "Welcome Back to Good Food",
                fontSize = 40.sp,
                fontFamily = poppinsFontFamily,
                color = colorResource(id = R.color.amberOrange)
            )

        }
        Column {
            TextField(
                value = email,
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
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = password,
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

        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
            Switch(checked = isChecked, onCheckedChange = {isChecked=it}, colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = colorResource(
                id = R.color.amberOrange
            ), uncheckedThumbColor = Color.White, uncheckedTrackColor = colorResource(id = R.color.amberOrange)
            ))
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "Remember", fontFamily = poppinsFontFamily)
            Spacer(modifier = Modifier.width(170.dp))
            Text(text = "Forget ?", fontFamily = poppinsFontFamily)

        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Button(
                onClick = {
                    // Check if email or password is empty
                    if (email.isBlank()) {
                        Toast.makeText(context, "Email field is empty", Toast.LENGTH_LONG).show()
                    } else if (password.isBlank()) {
                        Toast.makeText(context, "Password field is empty", Toast.LENGTH_LONG).show()
                    } else {
                        // Proceed with login if fields are not empty
                        loginScreenViewModel.signInUser(email, password) { isSuccess, error ->
                            if (isSuccess) {
                                navController.navigate(Routes.HomeScreen)
                            } else {
                                Toast.makeText(context, "$error", Toast.LENGTH_LONG).show()
                            }
                        }
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
                Text(text = "Log In", fontFamily = poppinsFontFamily)
            }


        }
    }

}
