package com.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.template.ui.home.HomeScreen
import com.template.ui.login.LoginScreen

@Composable
fun NavigationWrapper () {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home){

        composable<Login> {
           LoginScreen()
        }

        composable<Home> {
            HomeScreen()
        }
    }
}