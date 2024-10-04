package com.abdroid.medicalapp.common

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.domain.model.Doctor
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun TopDoctorHomeCard(
    doctor: Doctor,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .width(130.dp)
            .border(
                1.dp,
                colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onClick()
            }
            .padding(10.dp),
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                painter = rememberAsyncImagePainter(model = doctor.image), // Use Coil to load the doctor's image
                contentScale = ContentScale.Crop,
                contentDescription = "image"
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Dr. ${doctor.name}",
                    fontSize = 12.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.main_text),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 1.sp // Adjust line height if needed
                )
                Text(
                    text = doctor.specialty,
                    fontSize = 10.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.second_text),
                )
            }

            Row(
                Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(color = colorResource(id = R.color.rate_box_color))
                        .padding(horizontal = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(10.dp),
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "",
                        tint = colorResource(id = R.color.colored_icon),
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "${doctor.rate}",
                        fontSize = 10.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.text_button),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(10.dp),
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "",
                        tint = colorResource(id = R.color.second_text),
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "${doctor.distance}m away",
                        fontSize = 10.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.second_text),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@Composable
fun TopDoctorCard(
    doctor: Doctor,
    showBorder: Boolean ,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .then(
                if (showBorder) {
                    Modifier
                        .border(
                            1.dp,
                            colorResource(id = R.color.text_field_border),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clip(RoundedCornerShape(8.dp))
                        .padding(8.dp)
                } else {
                    Modifier
                }
            )
    ){
        Row (
            modifier = Modifier.fillMaxWidth() ,
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Start
        ){
            Image(
                modifier = Modifier
                    .width(110.dp)
                    .height(110.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = rememberAsyncImagePainter(model = doctor.image),
                contentScale = ContentScale.Crop,
                contentDescription = "image"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.fillMaxSize().padding(vertical = 5.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Dr. ${doctor.name}",
                    fontSize = 18.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.main_text),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 1.sp
                )
                Text(
                    text = doctor.specialty,
                    fontSize = 12.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.second_text),
                )
                Row(
                    Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(color = colorResource(id = R.color.rate_box_color))
                        .padding(horizontal = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(10.dp),
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "",
                        tint = colorResource(id = R.color.colored_icon),
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "${doctor.rate}",
                        fontSize = 12.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.text_button),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(10.dp),
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "",
                        tint = colorResource(id = R.color.second_text),
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "${doctor.distance}m away",
                        fontSize = 12.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.second_text),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}


