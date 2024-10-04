package com.abdroid.medicalapp.presentation.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.common.MessageTextField
import com.abdroid.medicalapp.domain.model.Doctor
import com.abdroid.medicalapp.ui.theme.InterFont
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay


@Composable
fun ChatScreen(
    navController: NavController, doctor: Doctor
) {
    var message by rememberSaveable { mutableStateOf("") }
    var showMessageBox by rememberSaveable { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        delay(2000L)
        showMessageBox = true
    }

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
            .statusBarsPadding()
            .systemBarsPadding()
            .padding(horizontal = 20.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    Icon(
                        modifier = Modifier
                            .size(18.dp)
                            .clip(CircleShape)
                            .clickable {navController.popBackStack() },
                        painter = painterResource(id = R.drawable.arrow_left),
                        contentDescription = null,
                        tint = colorResource(id = R.color.main_text)
                    )

                    Text(
                        text = "Dr.${doctor.name}",
                        fontSize = 16.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.main_text),
                        textAlign = TextAlign.Center,
                    )
                }

                Row(
                    modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .size(18.dp)
                            .clip(CircleShape)
                            .clickable { /* Handle video call */ },
                        painter = painterResource(id = R.drawable.video),
                        contentDescription = null,
                        tint = colorResource(id = R.color.main_text)
                    )

                    Icon(
                        modifier = Modifier
                            .size(18.dp)
                            .clip(CircleShape)
                            .clickable { /* Handle voice call */ },
                        painter = painterResource(id = R.drawable.call),
                        contentDescription = null,
                        tint = colorResource(id = R.color.main_text)
                    )

                    Icon(
                        modifier = Modifier
                            .size(18.dp)
                            .clip(CircleShape)
                            .clickable { /* Handle options menu */ },
                        painter = painterResource(id = R.drawable.dots),
                        contentDescription = null,
                        tint = colorResource(id = R.color.main_text)
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp,
                        colorResource(id = R.color.text_field_border),
                        shape = RoundedCornerShape(18.dp)
                    )
                    .clip(RoundedCornerShape(18.dp))
                    .background(colorResource(id = R.color.background))
                    .padding(20.dp),
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Consultion Start",
                        fontSize = 16.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.main_button),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "You can consult your problem to the doctor",
                        fontSize = 16.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.second_text),
                        textAlign = TextAlign.Start
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            if (showMessageBox) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = rememberAsyncImagePainter(model = doctor.image),
                        contentScale = ContentScale.Crop,
                        contentDescription = "image"
                    )
                    Column {
                        Text(
                            text = "Dr. ${doctor.name}",
                            fontSize = 16.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.main_text),
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "now",
                            fontSize = 12.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.second_text),
                            textAlign = TextAlign.Start
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 10.dp,
                                bottomEnd = 10.dp,
                                bottomStart = 10.dp
                            )
                        )
                        .background(colorResource(id = R.color.rate_box_color))
                        .padding(12.dp),
                ) {
                    Text(
                        text = "Hello, How can I help you?",
                        fontSize = 16.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.main_text),
                        textAlign = TextAlign.Start
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Message Input Field
            MessageTextField(modifier = Modifier.weight(1f),
                hintValue = "Type message ...",
                leadingIcon = painterResource(id = R.drawable.paperclip),
                text = message,
                onTextChange = { newMessage -> message = newMessage })

            Spacer(modifier = Modifier.width(15.dp))

            Button(
                modifier = Modifier
                    .weight(.4f)
                    .height(60.dp), onClick = {
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.main_button),
                ), shape = RoundedCornerShape(size = 85.dp)
            ) {
                Text(
                    text = "Send",
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
