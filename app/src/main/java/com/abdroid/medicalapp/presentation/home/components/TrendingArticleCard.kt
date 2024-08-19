package com.abdroid.medicalapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.domain.model.Article
import com.abdroid.medicalapp.ui.theme.InterFont

@Composable
fun TrendingArticleCard(
    article: Article
) {
    Box(
        modifier = Modifier
            .width(300.dp)
            .border(
                1.dp,
                colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .padding(10.dp)
    ){
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = rememberAsyncImagePainter(model = article.image), // Use Coil to load the doctor's image
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
                contentDescription = "image"
            )
            Row(
                Modifier.fillMaxWidth()
            ){
                Text(
                    text = article.title,
                    fontSize = 16.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.main_text),
                    textAlign = TextAlign.Start,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Row(
                Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = article.date,
                    fontSize = 14.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.second_text),
                )
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .background(
                            color = colorResource(id = R.color.second_text),
                            shape = CircleShape
                        )
                )
                Text(
                    text = "${article.minRead} min read",
                    fontSize = 14.sp,
                    fontFamily = InterFont,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.text_button),
                )
            }
        }
    }

}

