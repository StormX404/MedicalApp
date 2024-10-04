package com.abdroid.medicalapp.presentation.doctorDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State



class DoctorDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // State variables
    var selectedDayAndDate by mutableStateOf(savedStateHandle.get<Pair<String, Int>?>("selectedDayAndDate"))

    var selectedTimeSlot by mutableStateOf(savedStateHandle.get<String?>("selectedTimeSlot"))

    var isExpanded by mutableStateOf(savedStateHandle.get<Boolean>("isExpanded") ?: false)

    private val _reason = mutableStateOf("")
    val reason: State<String> = _reason

    fun updateReason(newReason: String) {
        _reason.value = newReason
    }

}
