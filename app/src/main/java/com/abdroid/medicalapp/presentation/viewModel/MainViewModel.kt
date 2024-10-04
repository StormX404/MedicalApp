package com.abdroid.medicalapp.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdroid.medicalapp.domain.repository.AuthRepository
import com.abdroid.medicalapp.domain.use_cases.AppEntryUseCases
import com.abdroid.medicalapp.presentation.navigation.Route
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    appEntryUseCases: AppEntryUseCases,
    private val repository: AuthRepository
): ViewModel() {

    private val _splashCondition = mutableStateOf(true)
    val splashCondition: State<Boolean> = _splashCondition

    private val _startDestination = mutableStateOf(Route.AppStartNavigation.route    )
    val startDestination: State<String> = _startDestination

    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                _startDestination.value = Route.EntryNavigation.route
            }else{
                _startDestination.value = Route.AppStartNavigation.route
            }
            delay(600L)
            _splashCondition.value = false
        }.launchIn(viewModelScope)

    }
    val currentUser: FirebaseUser?
        get() = repository.currentUser
}