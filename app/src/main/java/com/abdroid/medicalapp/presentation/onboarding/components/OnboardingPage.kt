package com.abdroid.medicalapp.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.presentation.onboarding.Page
import com.abdroid.medicalapp.ui.theme.AlbertSansFont

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page,
){
    Box(modifier = modifier) {
        Image(
            modifier = Modifier,
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Image(
            modifier = Modifier,
            painter = painterResource(id = R.drawable.overlay),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column (
            modifier = modifier.fillMaxSize().padding(bottom = 150.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        )
        {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = page.title,
                fontSize = 22.sp,
                fontFamily = AlbertSansFont,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Start
            )
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = page.description,
                fontSize = 14.sp,
                fontFamily = AlbertSansFont,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                textAlign = TextAlign.Start
            )
        }

    }
}
