package com.abdroid.medicalapp.presentation.doctorDetails

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.common.TopAppBar
import com.abdroid.medicalapp.domain.model.Doctor
import com.abdroid.medicalapp.presentation.doctorDetails.components.DateItem
import com.abdroid.medicalapp.presentation.doctorDetails.components.TimeSlotItem
import com.abdroid.medicalapp.presentation.home.components.TopDoctorCard
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun DoctorDetailsScreen(
    navController: NavController,
    doctor: Doctor,
) {
    val dates = listOf(
        "Mon" to 21,
        "Tue" to 22,
        "Wed" to 23,
        "Thu" to 24,
        "Fri" to 25,
        "Sat" to 26,
        "Sun" to 27,
        "Mon" to 28,
        "Tue" to 29,
        "Wed" to 30
    )

    val timeSlots = listOf(
        "09:00 AM" to false,
        "10:00 AM" to true,
        "11:00 AM" to false,
        "01:00 PM" to false,
        "02:00 PM" to true,
        "03:00 PM" to true,
        "04:00 PM" to true,
        "07:00 PM" to true,
        "08:00 PM" to false,
    )

    var selectedDayAndDate by remember { mutableStateOf(dates.first()) }
    var selectedTimeSlot by remember { mutableStateOf<String?>(null) }
    var isExpanded by remember { mutableStateOf(false) }

    val truncatedText = if (doctor.about.length > 120) {
        buildAnnotatedString {
            append(doctor.about.take(120))
            withStyle(style = SpanStyle(color = colorResource(id = R.color.text_button) ,
                fontSize = 14.sp,
                fontFamily = InterFont,
                fontWeight = FontWeight.Normal)
            ) {
                append(" ...Read more")
            }
        }
    } else {
        buildAnnotatedString { append(doctor.about) }
    }

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
            .statusBarsPadding()
            .systemBarsPadding()
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp)
        ) {
            TopAppBar(
                onDotsClick = { },
                "Doctor Detail",
                navController,
            )

            Spacer(modifier = Modifier.height(20.dp))

            TopDoctorCard(doctor = doctor, showBorder = false)

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "About",
                fontSize = 16.sp,
                fontFamily = InterFont,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.main_text),
                textAlign = TextAlign.Start,
            )

            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box(
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        isExpanded = true
                    },
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (!isExpanded) {
                        Text(
                            text = truncatedText,
                            fontSize = 14.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.second_text),
                            textAlign = TextAlign.Start,
                        )
                    }
                }

                AnimatedVisibility(
                    visible = isExpanded,
                    enter = expandVertically(animationSpec = tween(250)),
                    exit = shrinkVertically(animationSpec = tween(250))
                ) {
                    Column {
                        Text(
                            text = doctor.about,
                            fontSize = 14.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.second_text),
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = "Show less",
                            fontSize = 14.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.text_button),
                            textAlign = TextAlign.Start,
                            modifier = Modifier.clickable {
                                isExpanded = false
                            }
                        )
                    }
                }

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(dates) { datePair ->
                        DateItem(
                            day = datePair.first,
                            date = datePair.second,
                            isSelected = selectedDayAndDate == datePair,
                            onClick = { selectedDayAndDate = datePair }
                        )
                    }
                }

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = colorResource(id = R.color.divider)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(155.dp)
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(timeSlots) { timeSlotPair ->
                            val time = timeSlotPair.first
                            val isEnabled = timeSlotPair.second
                            TimeSlotItem(
                                time = time,
                                isSelected = selectedTimeSlot == time,
                                isEnabled = isEnabled,
                                onClick = { if (isEnabled) selectedTimeSlot = time }
                            )
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                modifier = Modifier
                    .height(60.dp),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.rate_box_color),
                ),
                shape = RoundedCornerShape(size = 15.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(25.dp),
                    painter = painterResource(id = R.drawable.message_circle),
                    contentDescription = "",
                    tint = colorResource(id = R.color.colored_icon),
                )
            }
            Button(
                modifier = Modifier
                    .weight(.9f)
                    .padding(start = 14.dp)
                    .height(60.dp),
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.main_button),
                ),
                shape = RoundedCornerShape(size = 85.dp)
            ) {
                Text(
                    text = "Book Apointment",
                    fontSize = 16.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}
