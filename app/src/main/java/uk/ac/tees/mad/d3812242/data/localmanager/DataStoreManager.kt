package uk.ac.tees.mad.d3812242.data.localmanager

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

val Context.dataStore by preferencesDataStore(name = "app_preferences")

class DataStoreManager(private val context: Context) {
    companion object {
        private val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
        private val USER_LOGGED_IN = booleanPreferencesKey("user_logged_in")
    }

    // Onboarding Status
    suspend fun setOnboardingCompleted(isCompleted: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[ONBOARDING_COMPLETED] = isCompleted
        }
    }

    suspend fun isOnboardingCompleted(): Boolean {
        val preferences = context.dataStore.data.first()
        return preferences[ONBOARDING_COMPLETED] ?: false
    }

    // Login Status
    suspend fun setUserLoggedIn(isLoggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[USER_LOGGED_IN] = isLoggedIn
        }
    }

    suspend fun isUserLoggedIn(): Boolean {
        val preferences = context.dataStore.data.first()
        return preferences[USER_LOGGED_IN] ?: false
    }
}
