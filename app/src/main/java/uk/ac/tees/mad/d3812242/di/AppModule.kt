package uk.ac.tees.mad.d3812242.di

import android.content.Context
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    @Singleton
    fun provideFirebaseDatabase():FirebaseDatabase{

        return Firebase.database

    }

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth{

        return FirebaseAuth.getInstance()

    }
    @Provides
    @Singleton
    @Named("root")
    fun provideFirebaseDatabaseReference(database: FirebaseDatabase):DatabaseReference{
        return database.reference
    }

    @Provides
    @Singleton
    fun provideSignInClient(@ApplicationContext context: Context): SignInClient {
        return Identity.getSignInClient(context)
    }


}