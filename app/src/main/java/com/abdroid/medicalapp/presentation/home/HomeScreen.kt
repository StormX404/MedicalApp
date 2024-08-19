package com.abdroid.medicalapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.presentation.home.components.IconItem
import com.abdroid.medicalapp.common.SearchBar
import com.abdroid.medicalapp.common.ShimmerEffect
import com.abdroid.medicalapp.presentation.home.components.SliderBanner
import com.abdroid.medicalapp.presentation.home.components.TopDoctorHomeCard
import com.abdroid.medicalapp.presentation.home.components.TrendingArticleCard
import com.abdroid.medicalapp.presentation.navigation.Route
import com.abdroid.medicalapp.ui.theme.InterFont
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    navigateToSearch: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val doctorsList = viewModel.doctorsList
    val articlesList = viewModel.articlesList
    val isLoading = viewModel.isLoading

    if (isLoading){
        ShimmerEffect()
    }else{
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.background))
                .fillMaxSize()
                .statusBarsPadding()
                .systemBarsPadding()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth().padding(top = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Find your desire \nhealth solution",
                        fontSize = 22.sp,
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.main_text),
                        textAlign = TextAlign.Start,
                    )
                    Icon(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .clickable(
                                onClick = {
                                },
                            ),
                        painter = painterResource(id = R.drawable.bell),
                        contentDescription = "",
                        tint = colorResource(id = R.color.main_text),
                    )
                }
                SearchBar(
                    text = "",
                    readOnly = true,
                    onValueChange = {},
                    onSearch = {},
                    onClick = { },
                    weight = 1f
                )
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconItem("Doctor", R.drawable.stethoscope)
                        IconItem("Pharmacy", R.drawable.pill)
                        IconItem("Hospital", R.drawable.hospital)
                        IconItem("Ambulance", R.drawable.ambulance)
                    }
                    SliderBanner()
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Top Doctor",
                            fontSize = 16.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = R.color.main_text),
                            textAlign = TextAlign.Start,
                        )
                        Text(
                            modifier = Modifier.clickable {
                                navController.navigate("topDoctorScreen")
                            },
                            text = "See all",
                            fontSize = 16.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = R.color.nav_bar_selected_icon),
                            textAlign = TextAlign.Start,
                        )
                    }
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(doctorsList.take(4)) { doctor ->
                            TopDoctorHomeCard(doctor = doctor, onClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    "doctor",
                                    doctor
                                )
                                navController.navigate(
                                    route = Route.DoctorDetailsScreen.route
                                )
                            })
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Health article",
                            fontSize = 16.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = R.color.main_text),
                            textAlign = TextAlign.Start,
                        )
                        Text(
                            modifier = Modifier.clickable { },
                            text = "See all",
                            fontSize = 16.sp,
                            fontFamily = InterFont,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = R.color.nav_bar_selected_icon),
                            textAlign = TextAlign.Start,
                        )
                    }
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(articlesList) { article ->
                            TrendingArticleCard(article = article)
                        }
                    }
                }
            }
        }
    }

}
