package com.abdroid.medicalapp.presentation.signIn_UpFlow.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdroid.medicalapp.domain.repository.AuthRepository
import com.abdroid.medicalapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _signUpState  = Channel<SignUpState>()
    val signUpState  = _signUpState.receiveAsFlow()


    fun registerUser(name :String ,email:String, password:String) = viewModelScope.launch {
        repository.registerUser( name , email, password).collect{result ->
            when(result){
                is Resource.Success ->{
                    _signUpState.send(SignUpState(isSuccess = true))
                }
                is Resource.Loading ->{
                    _signUpState.send(SignUpState(isLoading = true))
                }
                is Resource.Error ->{
                    _signUpState.send(SignUpState(isError = result.message))
                }
            }

        }
    }
}