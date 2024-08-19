package com.abdroid.medicalapp.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun IconItem(
    text: String,
    icon: Int
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(55.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(colorResource(id = R.color.text_field_bg))
                .clickable(
                    onClick = {}
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(icon),
                contentDescription = "",
                tint = colorResource(id = R.color.colored_icon),
            )
        }
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = InterFont,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.second_text),
            textAlign = TextAlign.Start,
        )
    }
}
