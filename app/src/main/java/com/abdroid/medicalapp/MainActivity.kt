package com.abdroid.medicalapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.abdroid.medicalapp.presentation.navigation.NavGraph
import com.abdroid.medicalapp.presentation.navigation.Route
import com.abdroid.medicalapp.presentation.viewModel.MainViewModel
import com.abdroid.medicalapp.ui.theme.MedicalAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLocaleToEnglish()

        WindowCompat.setDecorFitsSystemWindows(window, false)

        installSplashScreen().apply {
            setKeepOnScreenCondition { viewModel.splashCondition.value }
        }

        enableEdgeToEdge()

        setContent {
            MedicalAppTheme(dynamicColor = false) {

                SetupSystemUI()

                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    NavigateBasedOnUser(viewModel)
                }
            }
        }
    }

    private fun setLocaleToEnglish() {
        val locale = Locale("en")
        Locale.setDefault(locale)
        val config = Configuration(resources.configuration)
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    @Composable
    private fun NavigateBasedOnUser(viewModel: MainViewModel) {
        val isUserVerified = viewModel.currentUser?.isEmailVerified == true
        NavGraph(
            startDestination = if (isUserVerified) Route.HomeNavigation.route
            else viewModel.startDestination.value
        )
    }

    @Composable
    private fun SetupSystemUI() {
        val isSystemInDarkMode = isSystemInDarkTheme()
        val systemController = rememberSystemUiController()

        SideEffect {
            systemController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = !isSystemInDarkMode
            )
        }
    }
}
