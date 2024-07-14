package com.example.mvidemo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SalesList(
    val salesListId: Int,
    val salesListName: String,
    val details: GoodsDetails
)

@Serializable
data class GoodsDetails(
    val goodsId: Int,
    val goodsName: String,
    val price: Double,
    val description: String,
    val taxType: String,
    val taxRate: Double,
    val imageUrl: String
)
