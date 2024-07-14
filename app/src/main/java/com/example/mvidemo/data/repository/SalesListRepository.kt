package com.example.mvidemo.data.repository

import com.example.mvidemo.data.datasource.SalesListDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SalesListRepository @Inject constructor(
    private val salesListDataSource: SalesListDataSource
) {
    suspend fun getData() = salesListDataSource.getData()
}