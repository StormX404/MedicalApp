package com.abdroid.medicalapp.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun ProfileCard(
    icon : Painter,
    text : String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween ,
        verticalAlignment = Alignment.CenterVertically )
    {
        Row ( modifier = Modifier
            ,horizontalArrangement = Arrangement.SpaceBetween ,
            verticalAlignment = Alignment.CenterVertically ){
            Box (
                modifier = Modifier
                    .clip(CircleShape)
                    .background(colorResource(id = R.color.rate_box_color))
                    .padding(8.dp)
            ){
                Icon(
                    modifier = Modifier.size(26.dp),
                    painter = icon,
                    contentDescription = null,
                    tint = colorResource(id = R.color.main_button)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = text,
                fontFamily = InterFont,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = colorResource(id = R.color.main_text)
            )
        }
        Icon(
            modifier = Modifier.size(18.dp),
            painter = painterResource(id = R.drawable.arrow_right),
            contentDescription = null,
            tint = colorResource(id = R.color.text_field_icon)
        )
    }
}

@Composable
fun RedProfileCard(
    icon : Painter,
    text : String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween ,
        verticalAlignment = Alignment.CenterVertically )
    {
        Row ( modifier = Modifier
            ,horizontalArrangement = Arrangement.SpaceBetween ,
            verticalAlignment = Alignment.CenterVertically ){
            Box (
                modifier = Modifier
                    .clip(CircleShape)
                    .background(colorResource(id = R.color.rate_box_color))
                    .padding(8.dp)
            ){
                Icon(
                    modifier = Modifier.size(26.dp),
                    painter = icon,
                    contentDescription = null,
                    tint = colorResource(id = R.color.rose_color)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = text,
                fontFamily = InterFont,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = colorResource(id = R.color.rose_color)
            )
        }
        Icon(
            modifier = Modifier.size(18.dp),
            painter = painterResource(id = R.drawable.arrow_right),
            contentDescription = null,
            tint = colorResource(id = R.color.text_field_icon)
        )
    }
}
