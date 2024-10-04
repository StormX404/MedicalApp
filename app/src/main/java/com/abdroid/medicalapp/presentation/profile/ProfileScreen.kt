package com.abdroid.medicalapp.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.common.LogOutDialog
import com.abdroid.medicalapp.presentation.navigation.Route
import com.abdroid.medicalapp.presentation.profile.components.ProfileCard
import com.abdroid.medicalapp.presentation.profile.components.RedProfileCard
import com.abdroid.medicalapp.ui.theme.InterFont
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = hiltViewModel()
) {

    val logoutDialog = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    if (logoutDialog.value) {
        LogOutDialog(
            title = "Are you sure to log out of your account?",
            buttonText = "Logout",
            onDismiss = { logoutDialog.value = false },
            onContinue = {
                logoutDialog.value = false
                navController.navigate(Route.EntryNavigation.route) {
                    // Specify the navigation options and set the popUpTo parameter
                    popUpTo(Route.HomeNavigation.route) {
                        inclusive = true // Include the start destination in popping
                    }
                }
                scope.launch {
                    delay(2000)
                    viewModel.signOut()
                }

            }
        )
    }

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.profile_background))
            .fillMaxSize()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.profile_background))
                .padding(horizontal = 20.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .clickable(
                            onClick = { },
                        ),
                    painter = painterResource(id = R.drawable.dots),
                    contentDescription = "",
                    tint = colorResource(id = R.color.main_button_text),
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Box {
                if (viewModel.currentUser?.photoUrl != null) {
                    AsyncImage(
                        model = viewModel.currentUser?.photoUrl,
                        contentDescription = "Profile picture",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                } else {
                    Image(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = null,
                    )
                }

                Button(
                    onClick = {
                        // navController.navigate(Route.PreScanScreen.route)
                    },
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.BottomEnd),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.background),
                        contentColor = colorResource(id = R.color.main_button)
                    ),
                ) {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = null,
                        tint = colorResource(id = R.color.main_button)
                    )
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = viewModel.currentUser?.displayName ?: "",
                fontFamily = InterFont,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.main_button_text)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoColumn(icon = R.drawable.heart, title = "Heart rate", info = "215 bpm")

                VerticalDivider(
                    modifier = Modifier.height(70.dp),
                    thickness = 1.dp,
                    color = colorResource(id = R.color.background)
                )

                InfoColumn(icon = R.drawable.water, title = "Calories", info = "756 Cal")

                VerticalDivider(
                    modifier = Modifier.height(70.dp),
                    thickness = 1.dp,
                    color = colorResource(id = R.color.background)
                )

                InfoColumn(icon = R.drawable.weight_1_svgrepo_com, title = "Weight", info = "103 Ibs")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(colorResource(id = R.color.background))
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 30.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            ProfileCard(icon = painterResource(id = R.drawable.heart_svgrepo_com), text = "My saved") {}

            HorizontalDivider( modifier = Modifier.fillMaxWidth(),  thickness = 1.dp,  color = colorResource(id = R.color.divider))

            ProfileCard(icon = painterResource(id = R.drawable.document), text = "Appointment") {}

            HorizontalDivider( modifier = Modifier.fillMaxWidth(),  thickness = 1.dp,  color = colorResource(id = R.color.divider))

            ProfileCard(icon = painterResource(id = R.drawable.wallet), text = "Payment Method") {}

            HorizontalDivider( modifier = Modifier.fillMaxWidth(),  thickness = 1.dp,  color = colorResource(id = R.color.divider))

            ProfileCard(icon = painterResource(id = R.drawable.message_circle), text = "FAQs") {}

            HorizontalDivider( modifier = Modifier.fillMaxWidth(),  thickness = 1.dp,  color = colorResource(id = R.color.divider))

            RedProfileCard(icon = painterResource(id = R.drawable.info_circle), text = "Logout") {
                logoutDialog.value = true
            }
        }
    }
}

@Composable
fun InfoColumn(icon: Int, title: String , info: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp)) {
        Icon(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            painter = painterResource(id = icon),
            contentDescription = "",
            tint = colorResource(id = R.color.main_button_text),
        )
        Text(
            text = title,
            fontFamily = InterFont,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.main_button_text)
        )
        Text(
            text = info,
            fontFamily = InterFont,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.main_button_text)
        )
    }
}

@Preview
@Composable
private fun ProfileScreenPrev() {

    InfoColumn(icon = R.drawable.message_circle, title = "Heart rate", info = "215bpm" )
}