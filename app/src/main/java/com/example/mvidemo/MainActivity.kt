package com.example.mvidemo

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import com.example.mvidemo.ui.component.FullScreenDialog
import com.example.mvidemo.ui.navigation.MainNavHost
import com.example.mvidemo.ui.theme.MviDemoTheme
import com.example.mvidemo.ui.util.enableFullScreen

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        enableFullScreen()
        setContent {
            MviDemoTheme {
                MainContents(modifier = Modifier.fillMaxSize())
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
fun MainContents(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary
    ) {
        Row {
            OutlinedButton(
                modifier = Modifier.padding(32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary,
                ),
                onClick = { showDialog = true }
            ) {
                Text(text = "Launch Dialog")
            }
            MainNavHost()
        }

        if (showDialog) {
            FullScreenDialog {
                showDialog = false
            }
        }
    }
}