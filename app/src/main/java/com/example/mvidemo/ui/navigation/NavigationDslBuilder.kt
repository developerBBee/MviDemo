package com.example.mvidemo.ui.navigation

import androidx.navigation.NavController

class NavigationDslBuilder(
    private val navController: NavController,
    private val sideEffect: TopNavigationBarSideEffect
) {
    fun onBack(action: NavController.() -> Unit) {
        if (sideEffect is TopNavigationBarSideEffect.Back) {
            navController.action()
        }
    }

    fun onNext(action: NavController.() -> Unit) {
        if (sideEffect is TopNavigationBarSideEffect.Next) {
            navController.action()
        }
    }
}

fun NavController.navigateSideEffect(
    sideEffect: TopNavigationBarSideEffect,
    block: NavigationDslBuilder.(NavController) -> Unit
) {
    NavigationDslBuilder(this, sideEffect).block(this)
}