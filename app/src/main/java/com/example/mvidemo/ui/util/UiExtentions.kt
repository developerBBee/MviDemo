package com.example.mvidemo.ui.util

import android.app.Activity
import android.os.Build
import android.view.Window
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

fun Activity.enableFullScreen() {
    window.enableFullScreen()
}

fun Window.enableFullScreen() {
    WindowInsetsControllerCompat(this, decorView).apply {
        systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        hide(WindowInsetsCompat.Type.systemBars()) // Android Q 以前に対して、完璧な互換性では無い
    }
}

fun Window.enableEdgeToEdge() {
    WindowCompat.setDecorFitsSystemWindows(this, false)
    isStatusBarContrastEnforced = false
    isNavigationBarContrastEnforced = false
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        attributes.layoutInDisplayCutoutMode =
            WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS
    } else {
        attributes.layoutInDisplayCutoutMode =
            WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
    }
}
