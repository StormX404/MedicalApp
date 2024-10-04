package com.abdroid.medicalapp.presentation.appointment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.common.CustomDialog
import com.abdroid.medicalapp.common.TopAppBarOneIcon
import com.abdroid.medicalapp.domain.model.Doctor
import com.abdroid.medicalapp.common.TopDoctorCard
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun AppointmentScreen(
    navController: NavController,
    doctor: Doctor,
    day: String,
    date: Int,
    hour: String,
    reason: String
) {
    val bookingDialog = remember { mutableStateOf(false) }

    val savedDay = rememberSaveable { mutableStateOf(day) }
    val savedDate = rememberSaveable { mutableIntStateOf(date) }
    val savedHour = rememberSaveable { mutableStateOf(hour) }
    val savedReason = rememberSaveable { mutableStateOf(reason) }

    if (bookingDialog.value) {
        CustomDialog(
            title = "Payment Success",
            desc = "Your payment has been successful, you can have a consultation session with your trusted doctor" ,
            buttonText = "Chat Doctor",
            onDismiss = {
                bookingDialog.value = false
                navController.currentBackStackEntry?.savedStateHandle?.set("doctor", doctor)
                navController.navigate("chatScreen")
            }
        )
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
                .padding(bottom = 70.dp)
        ) {
            TopAppBarOneIcon(
                "Appointment",
                navController,
            )

            Spacer(modifier = Modifier.height(20.dp))

            TopDoctorCard(doctor = doctor, showBorder = true)

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Date",
                        fontSize = 16.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.main_text),
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        modifier = Modifier.clickable {
                            // Handle date change
                        },
                        text = "Change",
                        fontSize = 14.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.second_text),
                        textAlign = TextAlign.Start,
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(colorResource(id = R.color.rate_box_color))
                            .padding(8.dp)
                            .clickable(
                                onClick = {}
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier,
                            painter = painterResource(R.drawable.calender_outlined),
                            contentDescription = "",
                            tint = colorResource(id = R.color.colored_icon),
                        )
                    }
                    Text(
                        text = "${savedDay.value}, jun ${savedDate.intValue},2024 | ${savedHour.value}",
                        fontSize = 15.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.main_text),
                        textAlign = TextAlign.Start,
                    )
                }
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = colorResource(id = R.color.divider)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Reason",
                        fontSize = 16.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.main_text),
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        modifier = Modifier.clickable {
                            // Handle date change
                        },
                        text = "Change",
                        fontSize = 14.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.second_text),
                        textAlign = TextAlign.Start,
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(colorResource(id = R.color.rate_box_color))
                            .padding(8.dp)
                            .clickable(
                                onClick = {}
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier,
                            painter = painterResource(R.drawable.edit),
                            contentDescription = "",
                            tint = colorResource(id = R.color.colored_icon),
                        )
                    }
                    Text(
                        text = savedReason.value,
                        fontSize = 15.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.main_text),
                        textAlign = TextAlign.Start,
                    )
                }
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = colorResource(id = R.color.divider)
                )
                Text(
                    text = "Payment Detail",
                    fontSize = 16.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.main_text),
                    textAlign = TextAlign.Start,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Consultation",
                        fontSize = 15.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.second_text),
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = "$60.00",
                        fontSize = 15.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.main_text),
                        textAlign = TextAlign.Start,
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Admin Fee",
                        fontSize = 15.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.second_text),
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = "$01.00",
                        fontSize = 15.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.main_text),
                        textAlign = TextAlign.Start,
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Additional Discount",
                        fontSize = 15.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.second_text),
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = "-",
                        fontSize = 15.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.main_text),
                        textAlign = TextAlign.Start,
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total",
                        fontSize = 15.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.main_text),
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = "$61.00",
                        fontSize = 15.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.text_button),
                        textAlign = TextAlign.Start,
                    )
                }
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = colorResource(id = R.color.divider)
                )
                Text(
                    text = "Payment Method",
                    fontSize = 16.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.main_text),
                    textAlign = TextAlign.Start,
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(colorResource(id = R.color.background))
                        .border(
                            1.dp,
                            colorResource(id = R.color.text_field_border),
                            RoundedCornerShape(12.dp)
                        ) // Add border here
                        .height(56.dp)
                        .padding(10.dp), // Set height to 56.dp
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            modifier = Modifier
                                .size(100.dp),
                            painter = painterResource(id = R.drawable.visa_logo),
                            contentScale = ContentScale.Fit,
                            contentDescription = "image"
                        )
                        Text(
                            modifier = Modifier.clickable {
                                // Handle date change
                            },
                            text = "Change",
                            fontSize = 14.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.second_text),
                            textAlign = TextAlign.Start,
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.height(60.dp),
                horizontalAlignment = Alignment.Start,
            ){
                Text(
                    text = "Total",
                    fontSize = 12.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.second_text),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = "$61.00",
                    fontSize = 16.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.main_text),
                    textAlign = TextAlign.Start,
                )
            }
            //Spacer(modifier = Modifier.width(60.dp))
            Button(
                modifier = Modifier
                    .weight(.9f)
                    .padding(start = 30.dp)
                    .height(60.dp),
                onClick = {
                    bookingDialog.value = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.main_button),
                ),
                shape = RoundedCornerShape(size = 85.dp)
            ) {
                Text(
                    text = "Booking",
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

