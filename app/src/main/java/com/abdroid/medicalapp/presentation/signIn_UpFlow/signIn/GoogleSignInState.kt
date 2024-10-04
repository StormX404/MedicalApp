package com.abdroid.medicalapp.presentation.signIn_UpFlow.signIn

import com.google.firebase.auth.AuthResult

data class GoogleSignInState(
    val success: AuthResult? = null,
    val loading: Boolean = false,
    val error: String = ""
)