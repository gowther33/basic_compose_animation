package com.example.compose_animation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController:NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController)
        }
        composable(
            route = "${Screen.Detail.route}/{data}"
        ){backStackEntry->
            val data = backStackEntry.arguments?.getString("data")
            DetailedScreen(navController, data!!)
        }
        composable(
            route = Screen.Draw.route
        ){
            DrawScreen(navController)
        }
    }

}