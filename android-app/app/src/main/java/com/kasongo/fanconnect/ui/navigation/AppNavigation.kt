package com.kasongo.fanconnect.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kasongo.fanconnect.ui.screens.home.HomeScreen
import com.kasongo.fanconnect.ui.screens.channel.ChannelScreen
import com.kasongo.fanconnect.ui.screens.community.CommunityScreen
import com.kasongo.fanconnect.ui.screens.booking.BookingScreen
import com.kasongo.fanconnect.ui.screens.profile.ProfileScreen
import com.kasongo.fanconnect.ui.screens.auth.LoginScreen
import com.kasongo.fanconnect.ui.screens.auth.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("channel") { ChannelScreen(navController) }
        composable("community") { CommunityScreen(navController) }
        composable("booking") { BookingScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
    }
}
