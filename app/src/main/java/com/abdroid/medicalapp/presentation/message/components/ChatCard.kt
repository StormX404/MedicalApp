package com.abdroid.medicalapp.presentation.message.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.domain.model.Doctor
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun ChatCard(
    doctor: Doctor,
    message : String,
    time : String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(.8f),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ){
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                painter = rememberAsyncImagePainter(model = doctor.image), // Use Coil to load the doctor's image
                contentScale = ContentScale.Crop,
                contentDescription = "image"
            )
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Dr.${doctor.name}",
                    fontSize = 16.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.main_text),
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = message,
                    fontSize = 14.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.second_text),
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = Ellipsis,
                )
            }
        }

        Column (
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ){
            Text(
                text = time,
                fontSize = 14.sp,
                fontFamily = InterFont,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.main_text),
                textAlign = TextAlign.Center,
            )
            Icon(
                modifier = Modifier
                    .size(14.dp),
                painter = painterResource(id = R.drawable.double_check_svgrepo_com),
                contentDescription = "",
                tint = colorResource(id = R.color.second_text),
            )
        }
    }
}
