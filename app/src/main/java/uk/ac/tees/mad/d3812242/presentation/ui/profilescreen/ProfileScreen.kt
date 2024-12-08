package uk.ac.tees.mad.d3812242.presentation.ui.profilescreen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import uk.ac.tees.mad.d3812242.R
import uk.ac.tees.mad.d3812242.presentation.navigation.Routes
import uk.ac.tees.mad.d3812242.presentation.navigation.bottomnavigation.BottomNavigationBar
import uk.ac.tees.mad.d3812242.viewmodels.SignUpScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSettingsScreen(navHostController: NavHostController,signUpScreenViewModel: SignUpScreenViewModel) {

    val poppinsFontFamily = FontFamily(Font(resId = R.font.poppins_semibold))
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            selectedImageUri = uri
        }

    var phoneNumber by remember {
        mutableStateOf(" Enter your PhoneNumber")
    }

    LaunchedEffect(Unit) {
        signUpScreenViewModel.fetchUsername()
    }

    val username = signUpScreenViewModel.username
    val email = signUpScreenViewModel.email

    var selectedTab by remember { mutableStateOf("Profile") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Profile settings") },
                navigationIcon = {
                    IconButton(onClick = { navHostController.navigateUp()}) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(onTabSelected = {
                selectedTab = it

                when (selectedTab) {
                    "Search" -> {

                        navHostController.navigate(Routes.SearchScreen)

                    }
                    "Saved" -> {

                        navHostController.navigate(Routes.BookMarkScreen)
                    }
                    "Profile" -> {
                        navHostController.navigate(Routes.ProfileScreen)
                    }
                    else -> {
                        navHostController.navigate(Routes.HomeScreen)
                    }
                }
            }, selectedTab = selectedTab)
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Text(
                    text = "Change your personal info.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

                // Profile image section
                Box(
                    modifier = Modifier
                        .size(220.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    if (selectedImageUri != null) {
                        Image(
                            painter = rememberAsyncImagePainter(selectedImageUri),
                            contentDescription = "Selected Profile Image",
                            modifier = Modifier
                                .size(120.dp)
                                .align(Alignment.Center)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.profile_placeholder_img), // Replace with your placeholder
                            contentDescription = "Placeholder Profile Image",
                            modifier = Modifier
                                .fillMaxSize().clip(CircleShape)
                                .clickable { launcher.launch("image/*") },
                        )

                    }
                }

                ProfileField(label = "Full name", value = username ?: "Loading...")
                ProfileField(label = "Email", value = email ?: "Loading...")
                ProfileField(label = "Phone number", value = "Enter your Phone Number")
                PasswordField(navHostController)

                Spacer(modifier = Modifier.weight(1f))



                OutlinedButton(
                    onClick = { navHostController.navigate(Routes.SignUpScreen) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.orange))
                ) {
                    Text(text = "Logout")
                }
            }
        }
    )
}

@Composable
fun ProfileField(label: String, value: String) {
    Column {
        Text(text = label, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
        BasicTextField(
            value = value,
            onValueChange = {},
            textStyle = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground),
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        HorizontalDivider(color = Color.Gray)
    }
}

@Composable
fun PasswordField(navHostController: NavHostController) {
    Column {
        Text(text = "Password", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = "********",
                onValueChange = {},
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                readOnly = true,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = { navHostController.navigate(Routes.LoginScreen)  }) {
                Text(text = "Change", color = colorResource(R.color.orange))
            }
        }
        HorizontalDivider(color = Color.Gray)
    }
}
