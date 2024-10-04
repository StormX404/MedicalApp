package com.abdroid.medicalapp.presentation.navigation


sealed class Route(
    val route: String,
) {
     data object AppStartNavigation : Route(route = "appStartNavigation")

     data object EntryNavigation : Route(route = "entryNavigation")

     data object HomeNavigation : Route(route = "homeNavigation")

     data object GetStartedScreen : Route(route = "getStartedScreen")

     data object SignInScreen : Route(route = "signInScreen")

     data object SignUpScreen : Route(route = "signUpScreen")

     data object HomeScreen : Route(route = "homeScreen")

     data object TopDoctorScreen : Route(route = "topDoctorScreen")

     data object DoctorDetailsScreen : Route(route = "doctorDetailsScreen")

     data object AppointmentScreen : Route(route = "appointmentScreen")

     data object ChatScreen : Route(route = "chatScreen")

     data object MessageScreen : Route(route = "messageScreen")

     data object ScheduleScreen : Route(route = "scheduleScreen")

     data object ProfileScreen : Route(route = "profileScreen")

     data object ForgotPasswordScreen : Route(route = "forgotPasswordScreen")

     data object OnBoardingScreen : Route(route = "onBoardingScreen")

}