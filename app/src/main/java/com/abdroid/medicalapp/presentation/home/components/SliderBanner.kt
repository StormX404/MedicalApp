package com.abdroid.medicalapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue
import androidx.compose.ui.util.lerp
import com.abdroid.medicalapp.R

@ExperimentalPagerApi
@Composable
fun SliderBanner(
    modifier: Modifier = Modifier
) {

    val pagerState = rememberPagerState(initialPage = 0)

    val imageSlider = listOf(
        painterResource(id = R.drawable.carousel_1),
        painterResource(id = R.drawable.carousel_2),
        painterResource(id = R.drawable.carousel_3),
        painterResource(id = R.drawable.carousel_4)
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }

    Column {
        HorizontalPager(
            count = imageSlider.size,
            state = pagerState,
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(2f / 1f)
        ) { page ->
            Card(
                backgroundColor = colorResource(id = R.color.text_field_bg),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        lerp(
                            start = 0.95f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        alpha = lerp(
                            start = 0.8f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                Image(
                    painter = imageSlider[page],
                    contentDescription = "Slider",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

