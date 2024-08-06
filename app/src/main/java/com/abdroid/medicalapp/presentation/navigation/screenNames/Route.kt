package com.abdroid.medicalapp.presentation.navigation.screenNames

sealed class Route(
    val route: String,
) {
    data object AppStartNavigation : Route(route = "appStartNavigation")

    data object EntryNavigation : Route(route = "entryNavigation")

    data object SplashScreen : Route(route = "splashScreen")

    data object GetStartedScreen : Route(route = "getStartedScreen")

    data object LoginScreen : Route(route = "loginScreen")


    data object OnBoardingScreen : Route(route = "onBoardingScreen")

}