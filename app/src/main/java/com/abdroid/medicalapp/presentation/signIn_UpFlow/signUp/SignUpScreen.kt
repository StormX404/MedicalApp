package com.abdroid.medicalapp.presentation.signIn_UpFlow.signUp

import android.widget.Toast
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.common.CustomDialog
import com.abdroid.medicalapp.common.EmailTextField
import com.abdroid.medicalapp.common.Loader
import com.abdroid.medicalapp.common.NameTextField
import com.abdroid.medicalapp.common.PasswordTextField
import com.abdroid.medicalapp.ui.theme.InterFont
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isPasswordOpen by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val state = viewModel.signUpState.collectAsState(initial = null)
    val scope = rememberCoroutineScope()
    val successDialog = remember { mutableStateOf(false) }

    if (successDialog.value) {
        CustomDialog(
            title = "Success",
            desc = "Your account has been successfully registered",
            buttonText = "Login",
            onDismiss = {
                successDialog.value = false
                navController.navigate("signInScreen")
            }
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
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
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
            Spacer(modifier = Modifier.weight(.9f))
            Text(
                text = "Sign Up",
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
            NameTextField(
                hintValue = "Enter your name",
                leadingIcon = painterResource(id = R.drawable.profile_outlined),
                name = name, onNameChange = { newName -> name = newName }
            )
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
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Checkbox(
                    checked = isChecked,
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = Color.White,
                        checkedColor = Color(0xFF50AAFA),
                        uncheckedColor = Color.Gray,
                    ),
                    onCheckedChange = { isChecked = it }
                )
                Text(
                    text = buildAnnotatedString {
                        append("I agree to the ")
                        withStyle(style = SpanStyle(color = colorResource(id = R.color.text_button))) {
                            append("Terms of Service")
                        }
                        append(" and ")
                        withStyle(style = SpanStyle(color = colorResource(id = R.color.text_button))) {
                            append("Terms of Service")
                        }
                    },
                    fontFamily = InterFont,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.main_text),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                onClick = {
                    scope.launch {
                        if (isChecked) {
                            viewModel.registerUser(name, email, password)
                        } else {
                            Toast.makeText(context, "Please agree to the Terms of Service", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    colorResource(id = R.color.main_button),
                ),
                shape = RoundedCornerShape(size = 85.dp)
            ) {
                if (state.value?.isLoading == true) {
                    Loader()
                } else {
                    Text(
                        modifier = Modifier,
                        text = "Sign Up",
                        fontSize = 16.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Already Have Account?",
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
                                navController.navigate("SignInScreen")
                            },
                        ),
                    text = "Sign In",
                    fontFamily = InterFont,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.text_button),
                )
            }
        }
    }

    LaunchedEffect(key1 = Pair(state.value?.isSuccess, state.value?.isError)) {
        scope.launch {
            val isSuccess = state.value?.isSuccess
            val isError = state.value?.isError

            when {
                // Case for success: show success dialog
                isSuccess == true -> {
                    successDialog.value = true
                }
                isError?.isNotBlank() == true -> {
                    Toast.makeText(context, isError, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPrev() {
    SignUpScreen(navController = rememberNavController())
}
