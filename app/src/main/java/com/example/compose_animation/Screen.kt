package com.example.compose_animation

sealed class Screen(val route:String) {

    object Home :Screen("home_screen")

    object Detail: Screen("detail_screen")
    object Draw: Screen("draw_screen")
}