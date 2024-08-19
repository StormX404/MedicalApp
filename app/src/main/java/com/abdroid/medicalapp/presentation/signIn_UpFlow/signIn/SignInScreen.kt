package com.abdroid.medicalapp.presentation.signIn_UpFlow.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.abdroid.medicalapp.common.CustomDialog
import com.abdroid.medicalapp.common.EmailTextField
import com.abdroid.medicalapp.common.PasswordTextField
import com.abdroid.medicalapp.common.SignInWith
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun SignInScreen(
    navController: NavController,
) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isPasswordOpen by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val successDialog = remember { mutableStateOf(false) }

    if (successDialog.value) {
        CustomDialog(
            title = "Yeay!Welcome Back",
            desc = "Once again you login successfully into medidoc app" ,
            buttonText = "Go to home",
            onDismiss = { successDialog.value = false
                navController.navigate("homeScreen")}
        )
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
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
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
            Spacer(modifier = Modifier.weight(.9f))
            Text(
                text = "Login",
                fontSize = 20.sp,
                fontFamily = InterFont,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.main_text),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        Column(
            modifier = Modifier.padding(top = 30.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            EmailTextField(
                hintValue = "Enter your email",
                leadingIcon = painterResource(id = R.drawable.sms),
                email = email, onEmailChange = { newEmail -> email = newEmail }
            )
            PasswordTextField(
                hintValue = "Enter your password",
                leadingIcon = painterResource(id = R.drawable.security_safe),
                password = password,
                onPasswordChange = { newPassword -> password = newPassword },
                isPasswordOpen = isPasswordOpen,
                onTogglePasswordVisibility = { isPasswordOpen = !isPasswordOpen }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    modifier = Modifier.clickable {
                        navController.navigate("forgotPasswordScreen")
                    },
                    text = "Forgot Password?",
                    fontSize = 14.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.text_button),
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                onClick = {
                    successDialog.value = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.main_button),
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Don't have an account?",
                    fontFamily = InterFont,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.second_text),
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .clickable(
                            onClick = {
                                navController.navigate("signUpScreen")
                            },
                        ),
                    text = "SignUp",
                    fontFamily = InterFont,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.text_button),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(painter = painterResource(id = R.drawable.line),
                    contentDescription = "line",)
                Text(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .clickable(
                            onClick = {

                            },
                        ),
                    text = "OR",
                    fontFamily = InterFont,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.second_text),
                )
                Image(painter = painterResource(id = R.drawable.line),
                    contentDescription = "line",)
            }
            SignInWith(icon = R.drawable.google, text = "Sign In with Google", onClick = {})

            SignInWith(icon = R.drawable.apple, text = "Sign In with Apple", onClick = {})

            SignInWith(icon = R.drawable.facebook, text = "Sign In with Facebook" , onClick = {})
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun SignInScreenPrev() {
    SignInScreen(navController = rememberNavController())
}
