package com.abdroid.medicalapp.presentation.signIn_UpFlow.forgotPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.abdroid.medicalapp.common.CustomTab
import com.abdroid.medicalapp.common.EmailTextField
import com.abdroid.medicalapp.common.PhoneTextField
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun ForgotPasswordScreen(navController: NavController) {

    //This screen is for display only and is not fully programmed

    var email by rememberSaveable { mutableStateOf("") }

    var phoneNumber by rememberSaveable { mutableStateOf("") }

    val (selected, setSelected) = remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
            .statusBarsPadding()
            .systemBarsPadding()
            .padding(horizontal = 20.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                modifier = Modifier
                    .size(20.dp)
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
        }
        Column(
            modifier = Modifier.padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "Forgot Your Password?",
                    fontSize = 22.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.main_text),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = "Enter Your email or your phone number , we will send you confirmation code",
                    fontSize = 16.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.second_text),
                    textAlign = TextAlign.Start,
                )
            }
            
            CustomTab(
                items = listOf("Email", "Phone"),
                selectedItemIndex = selected,
                onClick = setSelected,
            )
            if (selected == 0) {
                EmailTextField(
                    hintValue = "Enter your email",
                    leadingIcon = painterResource(id = R.drawable.sms),
                    email = email,
                    onEmailChange = { newEmail -> email = newEmail }
                )
            } else {
                PhoneTextField(
                    hintValue = "Enter your phone number",
                    leadingIcon = painterResource(id = R.drawable.call),
                    phoneNumber = phoneNumber,
                    onPhoneNumberChange = { newPhoneNumber -> phoneNumber = newPhoneNumber }
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.main_button),
                ),
                shape = RoundedCornerShape(size = 85.dp)
            ) {
                Text(
                    modifier = Modifier,
                    text = "Reset Password",
                    fontSize = 16.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.main_button_text),
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForgotPasswordScreenPrev() {
    ForgotPasswordScreen(navController = rememberNavController())
}