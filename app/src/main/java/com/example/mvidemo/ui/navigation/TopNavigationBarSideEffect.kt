package com.example.mvidemo.ui.navigation

sealed class TopNavigationBarSideEffect {
    data object Back : TopNavigationBarSideEffect()
    data object Next : TopNavigationBarSideEffect()
}
