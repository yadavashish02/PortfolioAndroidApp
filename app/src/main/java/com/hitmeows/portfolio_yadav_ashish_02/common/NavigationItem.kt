package com.hitmeows.portfolio_yadav_ashish_02.common

import com.hitmeows.portfolio_yadav_ashish_02.R

sealed class NavigationItem (val route: String, var icon: Int, var title: String) {
    object RatingScreen: NavigationItem("home", R.drawable.ic_home, "Home")
    object AboutAppScreen: NavigationItem ("about_app_screen", R.drawable.ic_info,"About App")
}
