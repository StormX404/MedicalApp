package com.abdroid.medicalapp.common

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.util.Dimens.IconSize

@Composable
fun AppBottomNavigation(
    items: List<BottomNavigationItem>,
    selectedItem: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier
            .background(colorResource(id = R.color.bottom_bar))
            .fillMaxWidth()
            .height(60.dp),
        containerColor = colorResource(id = R.color.bottom_bar)
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedItem,
                onClick = { onItemClick(index) },
                icon = {
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            painter = if (index == selectedItem) painterResource(id = item.filled)
                            else painterResource(id = item.iconOutlined),
                            contentDescription = null,
                            modifier = Modifier.size(IconSize),
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(

                    selectedIconColor = colorResource(id = R.color.nav_bar_selected_icon),
                    selectedTextColor = colorResource(id = R.color.nav_bar_selected_text),
                    unselectedIconColor = colorResource(id = R.color.nav_bar_un_selected_icon),
                    unselectedTextColor = colorResource(id = R.color.nav_bar_un_selected_text),
                    indicatorColor = Color.Transparent,
                ),
            )
        }
    }
}

data class BottomNavigationItem(
    @DrawableRes val iconOutlined : Int,
    @DrawableRes val filled : Int,
)

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NewsBottomNavigationPreview() {
    AppBottomNavigation(items = listOf(
        BottomNavigationItem(iconOutlined = R.drawable.home_outlined,filled = R.drawable.home_filled),
        BottomNavigationItem(iconOutlined = R.drawable.mail_outlined,filled = R.drawable.mail_filled),
        BottomNavigationItem(iconOutlined = R.drawable.calender_outlined,filled = R.drawable.calender_filled ),
        BottomNavigationItem(iconOutlined = R.drawable.profile_outlined,filled = R.drawable.profile_filled),
    ), selectedItem = 0, onItemClick = {})
}