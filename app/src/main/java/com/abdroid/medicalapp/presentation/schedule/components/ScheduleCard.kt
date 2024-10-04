package com.abdroid.medicalapp.presentation.schedule.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.domain.model.Doctor
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun ScheduleCard(
    doctor: Doctor,
    date: String,
    time: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                1.dp,
                colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Dr.${doctor.name}",
                    fontSize = 18.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.main_text),
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "Dr.${doctor.specialty}",
                    fontSize = 14.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.second_text),
                    textAlign = TextAlign.Center,
                )
            }
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                painter = rememberAsyncImagePainter(model = doctor.image),
                contentScale = ContentScale.Crop,
                contentDescription = "image"
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(14.dp),
                    painter = painterResource(id = R.drawable.calender_outlined),
                    contentDescription = "",
                    tint = Color.DarkGray,
                )
                Text(
                    text = date,
                    fontSize = 14.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(14.dp),
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "",
                    tint = Color.DarkGray,
                )
                Text(
                    text = time,
                    fontSize = 14.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(8.dp),
                    painter = painterResource(id = R.drawable.dot_single),
                    contentDescription = "",
                    tint = colorResource(id = R.color.confirmed_dot_color),
                )
                Text(
                    text = "Confirmed",
                    fontSize = 14.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                )
            }
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(
                modifier = Modifier
                    .width(165.dp)
                    .height(50.dp),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.rate_box_color),
                ),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Text(
                    modifier = Modifier,
                    text = "Cancel",
                    fontSize = 16.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.main_text),
                    textAlign = TextAlign.Start
                )
            }
            Button(
                modifier = Modifier
                    .width(165.dp)
                    .height(50.dp),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.main_button),
                ),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Text(
                    modifier = Modifier,
                    text = "Reschedule",
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

@Preview(showBackground = true)
@Composable
fun PreviewScheduleCard() {
    val sampleDoctor = Doctor(
        id = 1,
        name = "John Doe",
        specialty = "Cardiologist",
        image = "https://firebasestorage.googleapis.com/v0/b/medical-app-a6104.appspot.com/o/male%20doctor.jpg?alt=media&token=981085de-0593-489f-b213-ed7ecf66dae3",
        about = "Expert in heart diseases with 10 years of experience.",
        distance = 5,
        rate = 4.5
    )

    ScheduleCard(
        doctor = sampleDoctor,
        date = "October 2, 2024",
        time = "10:30 AM"
    )
}