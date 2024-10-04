package com.abdroid.medicalapp.presentation.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.common.InsideCustomTab
import com.abdroid.medicalapp.presentation.home.HomeViewModel
import com.abdroid.medicalapp.presentation.schedule.components.ScheduleCard
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun ScheduleScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    //This screen is for display only and is not fully programmed

    val doctorsList = viewModel.doctorsList

    val (selected, setSelected) = remember {
        mutableIntStateOf(0)
    }

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
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Schedule",
                fontSize = 24.sp,
                fontFamily = InterFont,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.main_text),
                textAlign = TextAlign.Center,
            )
            Icon(
                modifier = Modifier,
                painter = painterResource(R.drawable.bell),
                contentDescription = "",
                tint = colorResource(id = R.color.black_icon),
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        InsideCustomTab(
            items = listOf("Upcoming", "Completed" , "Cancelled"),
            selectedItemIndex = selected,
            onClick = setSelected,
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            val messages = listOf(
                "23/10/2024",
                "26/10/2024",
            )

            val times = listOf(
                "10:30 AM", "2:00 PM"
            )

            itemsIndexed(doctorsList.take(2)) { index, doctor ->
                ScheduleCard(
                    doctor = doctor,
                    date = messages.getOrElse(index) { "Default message" },
                    time = times.getOrElse(index) { "00:00" }
                )
            }
        }
    }
}