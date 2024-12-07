package uk.ac.tees.mad.d3812242

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint
import uk.ac.tees.mad.d3812242.presentation.navigation.CookBookComposableNavigationSystem
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.ac.tees.mad.d3812242.presentation.navigation.CookBookComposableNavigationSystem
import uk.ac.tees.mad.d3812242.presentation.ui.homescreen.HomeScreen
import uk.ac.tees.mad.d3812242.presentation.viewmodels.RecipeViewModel
import uk.ac.tees.mad.d3812242.ui.theme.CookBookTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private  val recipeViewModel: RecipeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            CookBookTheme {
                CookBookComposableNavigationSystem(context = this,recipeViewModel)

            }
        }
    }
}

