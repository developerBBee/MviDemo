package com.example.mvidemo.ui.screen

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Surface(modifier = modifier) {
        Text(text = "Detail Screen")
    }
}