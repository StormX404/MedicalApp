package com.abdroid.medicalapp.presentation.onboarding

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.presentation.onboarding.components.OnBoardingPage
import com.abdroid.medicalapp.ui.theme.AlbertSansFont
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    onEvent: (OnBoardingEvents) -> Unit
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }

    val progressValues = listOf(0.3f, 0.6f, 1f)
    val targetProgress by remember { derivedStateOf { progressValues[pagerState.currentPage] } }
    val animatedProgress by animateFloatAsState(targetValue = targetProgress, label = "")

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (pagerState.currentPage == 2) {
                Button(
                    modifier = Modifier
                        .width(343.dp)
                        .height(60.dp),
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == 2) {
                                onEvent(OnBoardingEvents.SaveAppEntry)
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.main_button),
                    ),
                    shape = RoundedCornerShape(size = 85.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        text = "Get started",
                        fontSize = 16.sp,
                        fontFamily = AlbertSansFont,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                }
            } else {
                Box(contentAlignment = Alignment.Center) {
                    Button(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape),
                        onClick = {
                            scope.launch {
                                if (pagerState.currentPage == 2) {
                                    onEvent(OnBoardingEvents.SaveAppEntry)
                                } else {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.main_button),
                        ),
                        shape = CircleShape
                    ) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.arrow_narrow_right),
                            tint = colorResource(id = R.color.main_icon_button),
                            contentDescription = "icon"
                        )
                    }
                    CircularProgressIndicator(
                        progress = { animatedProgress },
                        modifier = Modifier.size(80.dp),
                        color = colorResource(id = R.color.main_button),
                        strokeWidth = 1.2.dp,
                        trackColor = Color.White,
                    )
                }
            }
        }
    }
}
