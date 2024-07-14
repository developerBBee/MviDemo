package com.example.mvidemo

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvidemo.ui.common.LocalActivity
import com.example.mvidemo.ui.component.FullScreenDialog
import com.example.mvidemo.ui.navigation.MainNavHost
import com.example.mvidemo.ui.navigation.TopNavigationBar
import com.example.mvidemo.ui.navigation.TopNavigationBarViewModel
import com.example.mvidemo.ui.theme.MviDemoTheme
import com.example.mvidemo.ui.util.enableFullScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        enableFullScreen()
        setContent {
            MviDemoTheme {
                CompositionLocalProvider(LocalActivity provides this@MainActivity) {
                    MainContents(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
            enableFullScreen()
        }
    }
}

@Composable
fun MainContents(
    modifier: Modifier = Modifier,
    navViewModel: TopNavigationBarViewModel = hiltViewModel()
){
    var showDialog by remember { mutableStateOf(false) }
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary
    ) {
        Scaffold(
            topBar = { TopNavigationBar(navViewModel = navViewModel) }
        ) { paddingValues ->
            MainNavHost(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                navViewModel = navViewModel
            )
        }

        if (showDialog) {
            FullScreenDialog {
                showDialog = false
            }
        }
    }
}