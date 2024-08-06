package com.abdroid.medicalapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.abdroid.medicalapp.presentation.GetStartedScreen
import com.abdroid.medicalapp.presentation.SplashScreen
import com.abdroid.medicalapp.presentation.navigation.screenNames.Route
import com.abdroid.medicalapp.presentation.onboarding.OnBoardingScreen
import com.abdroid.medicalapp.presentation.onboarding.viewModel.OnboardingViewModel
import com.abdroid.medicalapp.presentation.signIn_UpFlow.signIn.SignInScreen

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {

        //AppStarting
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.SplashScreen.route,
        ) {
            composable(route = Route.SplashScreen.route) {
                SplashScreen(navController)
            }
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnboardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent)
            }

        }
        navigation(
            route = Route.EntryNavigation.route,
            startDestination = Route.GetStartedScreen.route,
        ) {
            composable(route = Route.GetStartedScreen.route) {
                GetStartedScreen(navController)
            }
            composable(route = Route.LoginScreen.route) {
                SignInScreen(navController)
            }
        }

    }

}
