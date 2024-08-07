package com.abdroid.medicalapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun GetStartedScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
            .statusBarsPadding()
            .systemBarsPadding()
            .padding(horizontal = 20.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Image(
            modifier = Modifier
                .padding(top = 100.dp)
                .size(164.dp),painter = painterResource(id = R.drawable.colored_logo),
            contentDescription = "logo",
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 50.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = "Let’s get started!",
                fontSize = 22.sp,
                fontFamily = InterFont,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.main_text),
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Login to enjoy the features we’ve provided, and stay healthy!",
                fontSize = 16.sp,
                fontFamily = InterFont,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.second_text),
                textAlign = TextAlign.Center,
            )
        }
        Button(
            modifier = Modifier
                .width(263.dp)
                .height(56.dp),
            onClick = {
                navController.navigate("signInScreen")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF50AAFA),
            ),
            shape = RoundedCornerShape(size = 85.dp)
        ) {
            Text(
                modifier = Modifier,
                text = "Login",
                fontSize = 16.sp,
                fontFamily = InterFont,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                textAlign = TextAlign.Start
            )
        }
        Button(
            modifier = Modifier
                .width(263.dp)
                .height(56.dp)
                .border(
                    1.dp,
                    Color(0xFF50AAFA),
                    shape = RoundedCornerShape(85.dp)
                ),
            onClick = {
                navController.navigate("signUpScreen")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.background),
            ),
            shape = RoundedCornerShape(size = 85.dp)
        ) {
            Text(
                modifier = Modifier,
                text = "Sign Up",
                fontSize = 16.sp,
                fontFamily = InterFont,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF50AAFA),
                textAlign = TextAlign.Start
            )
        }

    }
}

@Preview
@Composable
private fun GetStartedScreenPrev() {
    GetStartedScreen(navController = rememberNavController())
}