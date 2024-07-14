package com.example.mvidemo.ui.component

import android.os.Build
import android.view.WindowManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.example.mvidemo.ui.theme.MviDemoTheme
import com.example.mvidemo.ui.util.enableEdgeToEdge
import com.example.mvidemo.ui.util.enableFullScreen

@Composable
fun FullScreenDialog(
    onDismissClick: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissClick,
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = true,
            decorFitsSystemWindows = false,
        )
    ) {
        val view = LocalView.current
        val dialogWindow = (view.parent as? DialogWindowProvider)?.window
        dialogWindow?.apply {
            enableEdgeToEdge()
            enableFullScreen()
            setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        }

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
            dialogWindow?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN or
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        }

        Surface(
            modifier = if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
                Modifier.background(Color.Black.copy(alpha = 0.5f))
            } else {
                Modifier
            }
                .padding(64.dp)
                .fillMaxSize()
            ,
            shape = RoundedCornerShape(16.dp),
            tonalElevation = 100.dp,
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(32.dp),
                    text = "${dialogWindow?.attributes?.width}x${dialogWindow?.attributes?.height}"
                )
                Button(
                    modifier = Modifier.padding(32.dp),
                    onClick = {}
                ) {
                    Text(text = "Button")
                }
                Button(
                    modifier = Modifier.padding(32.dp),
                    onClick = onDismissClick
                ) {
                    Text(text = "Dismiss")
                }
            }
        }
    }
}

@Preview
@Composable
fun FullScreenDialogPreview() {
    MviDemoTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            FullScreenDialog {}
        }
    }
}