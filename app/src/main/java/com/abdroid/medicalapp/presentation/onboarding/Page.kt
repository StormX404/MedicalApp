package com.abdroid.medicalapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.abdroid.medicalapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Your Health, Your Way",
        description = "Seamless Access to On-Demand Healthcare Services.",
        image = R.drawable.onboarding_1
    ),
    Page(
        title = "Unlocking Health Insights",
        description = "Harnessing Smart Data for Your Wellness Journey.",
        image = R.drawable.onboarding_2
    ),
    Page(
        title = "Revolutionising Health Records",
        description = "Bringing Public Health Data to the Digital Frontier.",
        image = R.drawable.onboarding_3
    )
)