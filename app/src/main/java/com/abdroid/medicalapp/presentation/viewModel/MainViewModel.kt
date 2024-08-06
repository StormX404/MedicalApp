package com.abdroid.medicalapp.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdroid.medicalapp.domain.use_cases.AppEntryUseCases
import com.abdroid.medicalapp.presentation.navigation.screenNames.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    appEntryUseCases: AppEntryUseCases,
): ViewModel() {


    private val _startDestination = mutableStateOf(Route.AppStartNavigation.route    )
    val startDestination: State<String> = _startDestination

    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                _startDestination.value = Route.EntryNavigation.route
            }else{
                _startDestination.value = Route.AppStartNavigation.route
            }
            delay(1000L)
        }.launchIn(viewModelScope)

    }

}