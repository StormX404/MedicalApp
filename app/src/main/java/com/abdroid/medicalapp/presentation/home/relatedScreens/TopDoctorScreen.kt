package com.abdroid.medicalapp.presentation.home.relatedScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.common.TopAppBar
import com.abdroid.medicalapp.presentation.home.HomeViewModel
import com.abdroid.medicalapp.common.TopDoctorCard

@Composable
fun TopDoctorScreen(
    navController: NavController,
    viewModel : HomeViewModel = hiltViewModel()
) {
    val doctorsList = viewModel.doctorsList

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
            .statusBarsPadding()
            .systemBarsPadding()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        TopAppBar(
            onDotsClick = {  },
            "Top Doctor",
            navController,
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize().padding(top = 30.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(doctorsList) { doctor ->
                TopDoctorCard(doctor = doctor , showBorder = true )
            }
        }
    }
}

@Preview
@Composable
private fun TopDoctorScreenPrev() {
    TopDoctorScreen(navController = rememberNavController())
}