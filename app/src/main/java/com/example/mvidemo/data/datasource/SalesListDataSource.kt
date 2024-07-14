package com.example.mvidemo.data.datasource

import android.content.Context
import com.example.mvidemo.data.model.SalesList
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SalesListDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {
    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getData(): List<SalesList> {
        delay(100L)
        val inputStream = context.assets.open(FILE_NAME)
        return Json.decodeFromStream<List<SalesList>>(inputStream)
    }

    companion object {
        private const val FILE_NAME = "sales_list.json"
    }
}