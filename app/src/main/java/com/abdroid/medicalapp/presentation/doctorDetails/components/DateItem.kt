package com.abdroid.medicalapp.presentation.doctorDetails.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.abdroid.medicalapp.R

@Composable
fun DateItem(
    day: String,
    date: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) colorResource(id = R.color.nav_bar_selected_icon) else Color.Transparent,
        label = ""
    )
    val textColor by animateColorAsState(
        targetValue = if (isSelected) colorResource(id = R.color.main_button_text) else colorResource(id = R.color.second_text),
        label = ""
    )
    val dateColor by animateColorAsState(
        targetValue = if (isSelected) colorResource(id = R.color.main_button_text) else colorResource(id = R.color.main_text),
        label = ""
    )
    val borderColor by animateColorAsState(
        targetValue = if (isSelected) Color.Transparent else colorResource(id = R.color.text_field_border),
        label = ""
    )

    Box(
        modifier = Modifier
            .size(55.dp, 80.dp)
            .background(backgroundColor, RoundedCornerShape(20.dp))
            .border(
                1.dp,
                borderColor,
                RoundedCornerShape(20.dp)
            ) // Add border here
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = day, color = textColor)
            Text(text = date.toString(), color = dateColor, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
