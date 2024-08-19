package com.abdroid.medicalapp.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.navigation.NavController
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun TopAppBar(
    onDotsClick: () -> Unit,
    text: String,
    navController: NavController,
) {
    Row (
        modifier = Modifier
            .fillMaxWidth().padding(top = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(
            modifier = Modifier
                .size(18.dp)
                .clip(CircleShape)
                .clickable(
                    onClick = {
                        navController.popBackStack()
                    },
                ),
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "",
            tint = colorResource(id = R.color.main_text),
        )
        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = InterFont,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.main_text),
            textAlign = TextAlign.Center,
        )
        Icon(
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .clickable(
                    onClick = {
                        onDotsClick()
                    },
                ),
            painter = painterResource(id = R.drawable.dots),
            contentDescription = "",
            tint = colorResource(id = R.color.main_text),
        )
    }
}

@Composable
fun TopAppBarOneIcon(
    text: String,
    navController: NavController,
) {
    Row (
        modifier = Modifier
            .fillMaxWidth().padding(top = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(
            modifier = Modifier
                .size(18.dp)
                .clip(CircleShape)
                .clickable(
                    onClick = {
                        navController.popBackStack()
                    },
                ),
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "",
            tint = colorResource(id = R.color.main_text),
        )
        Spacer(modifier = Modifier.weight(.9f))
        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = InterFont,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.main_text),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}