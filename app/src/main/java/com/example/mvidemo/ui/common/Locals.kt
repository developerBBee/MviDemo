package com.example.mvidemo.ui.common

import android.app.Activity
import androidx.compose.runtime.staticCompositionLocalOf

val LocalActivity = staticCompositionLocalOf<Activity> {
    error("Activity not provided")
}