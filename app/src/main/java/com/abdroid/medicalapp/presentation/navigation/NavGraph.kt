package com.abdroid.medicalapp.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.common.AppBottomNavigation
import com.abdroid.medicalapp.common.BottomNavigationItem
import com.abdroid.medicalapp.domain.model.Doctor
import com.abdroid.medicalapp.presentation.appointment.AppointmentScreen
import com.abdroid.medicalapp.presentation.chat.ChatScreen
import com.abdroid.medicalapp.presentation.doctorDetails.DoctorDetailsScreen
import com.abdroid.medicalapp.presentation.home.HomeScreen
import com.abdroid.medicalapp.presentation.home.relatedScreens.TopDoctorScreen
import com.abdroid.medicalapp.presentation.message.MessageScreen
import com.abdroid.medicalapp.presentation.onboarding.GetStartedScreen
import com.abdroid.medicalapp.presentation.onboarding.OnBoardingScreen
import com.abdroid.medicalapp.presentation.onboarding.viewModel.OnboardingViewModel
import com.abdroid.medicalapp.presentation.profile.ProfileScreen
import com.abdroid.medicalapp.presentation.schedule.ScheduleScreen
import com.abdroid.medicalapp.presentation.signIn_UpFlow.forgotPassword.ForgotPasswordScreen
import com.abdroid.medicalapp.presentation.signIn_UpFlow.signIn.SignInScreen
import com.abdroid.medicalapp.presentation.signIn_UpFlow.signUp.SignUpScreen

@Composable
fun NavGraph(
    startDestination: String
) {

    val bottomNavigationItems = listOf(
        BottomNavigationItem(
            iconOutlined = R.drawable.home_outlined,
            filled = R.drawable.home_filled,
            contentDescription = "Home"
        ),
        BottomNavigationItem(
            iconOutlined = R.drawable.mail_outlined,
            filled = R.drawable.mail_filled,
            contentDescription = "Messages"
        ),
        BottomNavigationItem(
            iconOutlined = R.drawable.calender_outlined,
            filled = R.drawable.calender_filled,
            contentDescription = "Calendar"
        ),
        BottomNavigationItem(
            iconOutlined = R.drawable.profile_outlined,
            filled = R.drawable.profile_filled,
            contentDescription = "Profile"
        ),
    )

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    selectedItem = when (backStackState?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.MessageScreen.route -> 1
        Route.ScheduleScreen.route -> 2
        Route.ProfileScreen.route -> 3
        else -> 0
    }

    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route in listOf(
            Route.HomeScreen.route,
            Route.MessageScreen.route,
            Route.ScheduleScreen.route,
            Route.ProfileScreen.route
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                AppBottomNavigation(
                    items = bottomNavigationItems,
                    selectedItem = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTab(navController, Route.HomeScreen.route)
                            1 -> navigateToTab(navController, Route.MessageScreen.route)
                            2 -> navigateToTab(navController, Route.ScheduleScreen.route)
                            3 -> navigateToTab(navController, Route.ProfileScreen.route)
                        }
                    }
                )
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(bottom = bottomPadding),
        ) {

            //AppStarting
            navigation(
                route = Route.AppStartNavigation.route,
                startDestination = Route.OnBoardingScreen.route,
            ) {
                composable(route = Route.OnBoardingScreen.route) {
                    val viewModel: OnboardingViewModel = hiltViewModel()
                    OnBoardingScreen(onEvent = viewModel::onEvent)
                }
            }

            //Entry
            navigation(
                route = Route.EntryNavigation.route,
                startDestination = Route.GetStartedScreen.route,
            ) {
                composable(route = Route.GetStartedScreen.route) {
                    GetStartedScreen(navController)
                }

                composable(route = Route.SignInScreen.route) {
                    SignInScreen(navController)
                }

                composable(route = Route.SignUpScreen.route) {
                    SignUpScreen(navController)
                }

                composable(route = Route.ForgotPasswordScreen.route) {
                    ForgotPasswordScreen(navController)
                }
            }
            //Home
            navigation(
                route = Route.HomeNavigation.route,
                startDestination = Route.HomeScreen.route
            ) {
                composable(route = Route.HomeScreen.route) {
                    HomeScreen(
                        navController,
                    )
                }
                composable(route = Route.TopDoctorScreen.route) {
                    TopDoctorScreen(navController)
                }
                composable(route = Route.DoctorDetailsScreen.route) {
                    navController.previousBackStackEntry?.savedStateHandle?.get<Doctor?>("doctor")
                        ?.let { doctor ->
                            DoctorDetailsScreen(
                                navController,
                                doctor = doctor,
                            )
                        }

                }

                composable(route = Route.AppointmentScreen.route) {
                    navController.previousBackStackEntry?.savedStateHandle?.get<Doctor?>("doctor")
                        ?.let { doctor ->
                            val day = navController.previousBackStackEntry?.savedStateHandle?.get<String>("day") ?: ""
                            val date = navController.previousBackStackEntry?.savedStateHandle?.get<Int>("date") ?: 0
                            val hour = navController.previousBackStackEntry?.savedStateHandle?.get<String>("hour") ?: ""
                            val reason = navController.previousBackStackEntry?.savedStateHandle?.get<String>("reason") ?: ""

                            AppointmentScreen(
                                navController = navController,
                                doctor = doctor,
                                day = day,
                                date = date,
                                hour = hour,
                                reason = reason
                            )
                        }
                }

                composable(route = Route.ChatScreen.route) {
                    val doctor = navController.previousBackStackEntry?.savedStateHandle?.get<Doctor>("doctor")
                    doctor?.let {
                        ChatScreen(navController, it)
                    }
                }

                composable(route = Route.MessageScreen.route) {
                    OnBackClickStateSaver(navController = navController)
                    MessageScreen()
                }

                composable(route = Route.ScheduleScreen.route) {
                    OnBackClickStateSaver(navController = navController)
                    ScheduleScreen()
                }

                composable(route = Route.ProfileScreen.route) {
                    OnBackClickStateSaver(navController = navController)
                    ProfileScreen(
                        navController,
                    )
                }
            }
        }
    }
}

@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        if (!navController.popBackStack()) {
            navController.navigate(Route.HomeScreen.route) {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
        }
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screenRoute ->
            popUpTo(screenRoute) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}
