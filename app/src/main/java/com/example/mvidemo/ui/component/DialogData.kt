package com.example.mvidemo.ui.component

import androidx.annotation.StringRes

data class DialogData(
    @StringRes val title: Int,
    @StringRes val message: Int,
    @StringRes val positiveButtonText: Int,
    @StringRes val negativeButtonText: Int
)

class DialogPattern {
    companion object {
        val DEFAULT = DialogData(
            title = 0,
            message = 0,
            positiveButtonText = 0,
            negativeButtonText = 0
        )
    }
}