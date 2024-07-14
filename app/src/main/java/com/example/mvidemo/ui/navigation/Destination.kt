package com.example.mvidemo.ui.navigation

sealed class Destination(val route: String) {
    data object Main : Destination(route = "main")
    data object Detail : Destination(route = "detail")
}