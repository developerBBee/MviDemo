package com.example.mvidemo.ui.navigation

import androidx.annotation.StringRes
import com.example.mvidemo.R

data class TopNavigationBarState(
    @StringRes val titleId: Int = MainTitleResId,
    val showBackButton: Boolean = true,
    val enableBackButton: Boolean = true,
    val showNextButton: Boolean = false,
    val enableNextButton: Boolean = false,
) {
    companion object {
        val MainTitleResId = R.string.main_title
        val DetailTitleResId = R.string.detail_title
    }
}