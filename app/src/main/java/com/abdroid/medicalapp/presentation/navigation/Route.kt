package com.abdroid.medicalapp.presentation.navigation

sealed class Route(
    val route: String,
) {
    data object AppStartNavigation : Route(route = "appStartNavigation")

    data object EntryNavigation : Route(route = "entryNavigation")

    data object SplashScreen : Route(route = "splashScreen")

    data object GetStartedScreen : Route(route = "getStartedScreen")

    data object SignInScreen : Route(route = "signInScreen")

    data object SignUpScreen : Route(route = "signUpScreen")

    data object OnBoardingScreen : Route(route = "onBoardingScreen")

}