package uk.ac.tees.mad.d3812242.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import uk.ac.tees.mad.d3812242.models.User
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SignUpScreenViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    @Named("root")private val rootReference: DatabaseReference,
):ViewModel() {

    private var _isSignedUp=MutableStateFlow<Boolean>(true)
    val isSignedUp=_isSignedUp.asStateFlow()

    private var _errorMessage by mutableStateOf("")
    val errorMessage:String get() = _errorMessage

    fun signUpUser(username:String,email:String,password:String){

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{task ->

            if (task.isSuccessful){
                val userId=firebaseAuth.currentUser?.uid?: return@addOnCompleteListener
                val user= User(username, email, password)

                rootReference.child("users").child(userId).setValue(user).addOnCompleteListener { databaseTask ->
                    if (databaseTask.isSuccessful){
                        Log.d("SignUp","$_isSignedUp")
                    }
                }
            }else{
                _errorMessage=task.exception.toString()
            }
        }
    }

    var username by mutableStateOf<String?>(null)
        private set
    var email by mutableStateOf<String?>(null)
        private set

    fun fetchUsername() {
        val userId = firebaseAuth.currentUser?.uid
        if (userId != null) {
            rootReference.child("users").child(userId).get().addOnSuccessListener { snapshot ->
                val user = snapshot.getValue(User::class.java)
                username = user?.username
                email = user?.email
            }.addOnFailureListener { exception ->
                Log.e("FetchUsername", "Error fetching username: ${exception.message}")
            }
        } else {
            Log.e("FetchUsername", "User not logged in.")
        }
    }

}