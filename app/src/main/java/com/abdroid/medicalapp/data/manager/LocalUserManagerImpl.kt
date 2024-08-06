package com.abdroid.medicalapp.data.manager

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.abdroid.medicalapp.domain.manager.LocalUserManager
import com.abdroid.medicalapp.util.Constants
import com.abdroid.medicalapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        Log.d("LocalUserManager", "Saving app entry status to true")
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = true // Store the value in DataStore
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        Log.d("LocalUserManager", "Reading app entry status")
        return context.dataStore.data
            .map { preferences ->
                val appEntry = preferences[PreferencesKeys.APP_ENTRY] ?: false
                Log.d("LocalUserManager", "App entry status: $appEntry")
                appEntry
            }
    }
}

// Creating an extension function to get the DataStore instance :->
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

// Creating a Preference Key :->
private object PreferencesKeys {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}