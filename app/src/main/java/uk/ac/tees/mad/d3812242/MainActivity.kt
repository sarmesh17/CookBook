package uk.ac.tees.mad.d3812242

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint
import uk.ac.tees.mad.d3812242.presentation.navigation.CookBookComposableNavigationSystem
import uk.ac.tees.mad.d3812242.ui.theme.CookBookTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            CookBookTheme {
                CookBookComposableNavigationSystem(context = this)
            }
        }
    }
}

