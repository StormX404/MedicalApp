package com.abdroid.medicalapp.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun SignInWith(icon: Int, text: String , onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(
                1.dp,
                colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(85.dp)
            ),
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.background),
        ),
        shape = RoundedCornerShape(size = 85.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(22.dp)
                )
            }
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = text,
                fontSize = 16.sp,
                fontFamily = InterFont,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.main_text),
                textAlign = TextAlign.Center
            )
        }
    }
}