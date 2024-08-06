package com.abdroid.medicalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.abdroid.medicalapp.presentation.navigation.NavGraph
import com.abdroid.medicalapp.presentation.viewModel.MainViewModel
import com.abdroid.medicalapp.ui.theme.MedicalAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            MedicalAppTheme {
                NavGraph(startDestination = viewModel.startDestination.value)
            }
        }
    }
}