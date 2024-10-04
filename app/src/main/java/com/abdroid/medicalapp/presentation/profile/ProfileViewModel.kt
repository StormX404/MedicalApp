package com.abdroid.medicalapp.presentation.profile

import androidx.lifecycle.ViewModel
import com.abdroid.medicalapp.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {


    val currentUser: FirebaseUser?
        get() = repository.currentUser

    fun signOut(){
        repository.signOut()
    }

}