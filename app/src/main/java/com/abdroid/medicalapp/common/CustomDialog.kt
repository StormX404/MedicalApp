package com.abdroid.medicalapp.common

import  androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun CustomDialog(
    title: String,
    desc: String,
    buttonText: String,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Box(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
            ) {
                Box(
                    modifier = Modifier
                        .height(350.dp)
                        .background(
                            color = colorResource(id = R.color.text_field_bg),
                            shape = RoundedCornerShape(16.dp)
                        )

                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Box(
                            modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape)
                                .background(colorResource(id = R.color.dialog_icon_background)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(50.dp),
                                painter = painterResource(id = R.drawable.right),
                                contentDescription = "",
                                tint = colorResource(id = R.color.dialog_icon_color),
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ){
                            Text(
                                text = title,
                                fontFamily = InterFont,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = colorResource(id = R.color.main_text)
                            )
                            Text(
                                text = desc,
                                fontFamily = InterFont,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center,
                                color = colorResource(id = R.color.second_text)
                            )
                            Button(
                                modifier = Modifier
                                    .width(160.dp)
                                    .height(56.dp),
                                onClick = {
                                    onDismiss()
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.main_button),
                                ),
                                shape = RoundedCornerShape(size = 85.dp)
                            ) {
                                Text(
                                    modifier = Modifier,
                                    text = buttonText,
                                    fontSize = 16.sp,
                                    fontFamily = InterFont,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White,
                                    textAlign = TextAlign.Start
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CustomDialogPrev() {
    CustomDialog(title = "Yeay!Welcome Back", desc = "Once again you login successfully into medidoc app" , buttonText = "Go to home" ) {
        
    }
}