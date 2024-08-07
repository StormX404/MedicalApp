package com.abdroid.medicalapp.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun EmailTextField(
    hintValue: String,
    leadingIcon: Painter,
    email: String,
    onEmailChange: (String) -> Unit
) {

    var isEmailFocused by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .border(
                1.dp,
                colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(22.dp)
            )
            .clip(RoundedCornerShape(22.dp))
            .background(colorResource(id = R.color.text_field_bg))
            .padding(8.dp)
            .onFocusChanged { focusState ->
                isEmailFocused = focusState.isFocused
            },
        value = email,
        onValueChange = onEmailChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(
            color = colorResource(id = R.color.text_field_text),
            fontSize = 16.sp,
            fontFamily = InterFont,
            fontWeight = FontWeight.Normal,
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = leadingIcon,
                    contentDescription = null,
                    tint = if (isEmailFocused) Color(0xFF50AAFA) else colorResource(id = R.color.text_field_hint)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier.weight(1f)) {
                    if (email.isEmpty()) {
                        Text(
                            text = hintValue,
                            fontSize = 16.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.text_field_hint)
                        )
                    }
                    innerTextField()
                }
            }
        }
    )
}

@Composable
fun NameTextField(
    hintValue: String,
    leadingIcon: Painter,
    name: String,
    onNameChange: (String) -> Unit
) {
    val transformedName = remember(name) {
        name.split(" ").joinToString(" ") { it.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() } }
    }
    var isNameFocused by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .border(
                1.dp,
                colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(22.dp)
            )
            .clip(RoundedCornerShape(22.dp))
            .background(colorResource(id = R.color.text_field_bg))
            .padding(8.dp)
            .onFocusChanged { focusState ->
                isNameFocused = focusState.isFocused
            },
        value = transformedName,
        onValueChange = { newValue ->
            if (newValue.length <= 15) {
                onNameChange(newValue)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(
            color = colorResource(id = R.color.text_field_text),
            fontSize = 16.sp,
            fontFamily = InterFont,
            fontWeight = FontWeight.Normal,
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = leadingIcon,
                    contentDescription = null,
                    tint = if (isNameFocused) Color(0xFF50AAFA) else colorResource(id = R.color.text_field_hint)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier.weight(1f)) {
                    if (name.isEmpty()) {
                        Text(
                            text = hintValue,
                            fontSize = 16.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.text_field_hint)
                        )
                    }
                    innerTextField()
                }
            }
        }
    )
}

@Composable
fun PasswordTextField(
    hintValue: String,
    leadingIcon: Painter,
    password: String,
    onPasswordChange: (String) -> Unit,
    isPasswordOpen: Boolean,
    onTogglePasswordVisibility: () -> Unit
) {

    var isPasswordFocused by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .border(
                1.dp,
                colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(22.dp)
            )
            .clip(RoundedCornerShape(22.dp))
            .background(colorResource(id = R.color.text_field_bg))
            .padding(8.dp)
            .onFocusChanged { focusState ->
                isPasswordFocused = focusState.isFocused
            },

        value = password,
        onValueChange = onPasswordChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        maxLines = 1,
        singleLine = true,
        visualTransformation = if (!isPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
        textStyle = TextStyle(
            color = colorResource(id = R.color.text_field_text),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = InterFont,
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = leadingIcon,
                    contentDescription = null,
                    tint = if (isPasswordFocused) Color(0xFF50AAFA) else colorResource(id = R.color.text_field_hint)
                )
                Spacer(modifier = Modifier.width(10.dp))

                Box(modifier = Modifier.weight(1f)) {
                    if (password.isEmpty()) {
                        Text(
                            text = hintValue,
                            fontSize = 16.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.text_field_hint)
                        )
                    }
                    innerTextField()
                }
                IconButton(onClick = onTogglePasswordVisibility) {
                    if (!isPasswordOpen) {
                        Icon(
                            painter = painterResource(id = R.drawable.eye),
                            contentDescription = "",
                            tint = colorResource(id = R.color.text_field_eye),
                            modifier = Modifier.size(24.dp)
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.eye_slash),
                            contentDescription = "",
                            tint = colorResource(id = R.color.text_field_eye),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun PassTextFieldPrev() {
    PasswordTextField(hintValue = "Enter your password", leadingIcon = painterResource(id = R.drawable.security_safe), password = "", onPasswordChange = {}, isPasswordOpen = true, onTogglePasswordVisibility = {})
    //EmailTextField(hintValue = "Enter your email", leadingIcon = painterResource(id = R.drawable.sms), email = "", onEmailChange = {})
}
@Preview
@Composable
private fun EmailTextFieldPrev() {
    //PasswordTextField(hintValue = "Enter your password", leadingIcon = painterResource(id = R.drawable.security_safe), password = "", onPasswordChange = {}, isPasswordOpen = true, onTogglePasswordVisibility = {})
    EmailTextField(hintValue = "Enter your email", leadingIcon = painterResource(id = R.drawable.sms), email = "", onEmailChange = {})
}
@Preview
@Composable
private fun NameTextFieldPrev() {
    NameTextField(hintValue = "Enter your name", leadingIcon = painterResource(id = R.drawable.profile_outlined), name = "", onNameChange = {})
}
