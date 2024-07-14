package com.example.mvidemo.domain.usecase

import com.example.mvidemo.data.model.SalesList
import com.example.mvidemo.data.repository.SalesListRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetSalesListUseCase @Inject constructor(
    private val salesListRepository: SalesListRepository
) {
    suspend operator fun invoke(): List<SalesList> {
        return salesListRepository.getData()
    }
}