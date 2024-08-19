package com.abdroid.medicalapp.presentation.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun ScheduleScreen(
    navController: NavController,
    //navigateToSearch: () -> Unit,
    //viewModel: HomeViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
            .statusBarsPadding()
            .systemBarsPadding()
            .padding(horizontal = 20.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Schedule Screen",
            fontSize = 20.sp,
            fontFamily = InterFont,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.main_text),
            textAlign = TextAlign.Center,
        )
    }
}