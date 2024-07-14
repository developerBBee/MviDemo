package com.example.mvidemo.ui.screen.main

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvidemo.ui.navigation.TopNavigationBarSideEffect
import com.example.mvidemo.ui.navigation.TopNavigationBarViewModel
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    var showDialog by remember { mutableStateOf(false) }

    viewModel.collectSideEffect {
        when (it) {
            is MainSideEffect.ShowDialog -> {
                showDialog = true
            }
        }
    }
    Surface(modifier = modifier) {
        Text(text = "Main Screen")
    }
}