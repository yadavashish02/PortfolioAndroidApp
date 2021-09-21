package com.hitmeows.portfolio_yadav_ashish_02.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.hitmeows.portfolio_yadav_ashish_02.R
import com.hitmeows.portfolio_yadav_ashish_02.common.Constants
import com.hitmeows.portfolio_yadav_ashish_02.common.NavigationItem
import com.hitmeows.portfolio_yadav_ashish_02.presentation.about.components.AboutAppScreen
import com.hitmeows.portfolio_yadav_ashish_02.presentation.rating.components.RatingScreen
import com.hitmeows.portfolio_yadav_ashish_02.presentation.ui.theme.AshishYadavPortfolioTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AshishYadavPortfolioTheme {
                // A surface container using the 'background' color from the theme

                Scaffold (
                    topBar = { TopBar() },
                    bottomBar = { BottomNavigationBar(navController) }
                        ) {
                    Surface(color = MaterialTheme.colors.background) {
                        NavHost(navController = navController,
                            startDestination = NavigationItem.RatingScreen.route
                        ) {
                            composable(
                                route = NavigationItem.RatingScreen.route
                            ) {
                                RatingScreen()
                            }
                            composable(
                                route = NavigationItem.AboutAppScreen.route
                            ) {
                                AboutAppScreen() {
                                    val webpage: Uri = Uri.parse(Constants.GITHUB_LINK)
                                    val intent = Intent(Intent.ACTION_VIEW, webpage)
                                    startActivity(intent)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor =MaterialTheme.colors.onPrimary
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.RatingScreen,
        NavigationItem.AboutAppScreen
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = MaterialTheme.colors.onSurface,
                unselectedContentColor = MaterialTheme.colors.onSurface,
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}