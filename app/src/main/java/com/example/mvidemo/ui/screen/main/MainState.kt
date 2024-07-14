package com.example.mvidemo.ui.screen.main

import com.example.mvidemo.ui.common.UiStatus
import com.example.mvidemo.data.model.SalesList

data class MainState(
    val status: UiStatus = UiStatus.Loading,
    val salesLists: List<SalesList> = emptyList()
)
