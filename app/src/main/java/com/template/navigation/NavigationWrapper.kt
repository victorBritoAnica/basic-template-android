package com.template.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.template.ui.home.HomeScreen
import com.template.ui.login.LoginScreen
import com.template.ui.pokemon.PokemonListScreen

@Composable
fun NavigationWrapper () {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = PokemonList){

        composable<Login> {
           LoginScreen()
        }

        composable<Home> {
            HomeScreen()
        }

        composable<PokemonList>{
            PokemonListScreen()
        }
    }
}