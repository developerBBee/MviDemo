package com.example.mvidemo.ui.screen.main

sealed class MainSideEffect {
    data class ShowDialog(val message: String) : MainSideEffect()
}