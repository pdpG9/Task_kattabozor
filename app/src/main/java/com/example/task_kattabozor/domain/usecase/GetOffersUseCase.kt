package com.example.task_kattabozor.domain.usecase

import com.example.task_kattabozor.data.network.models.OffersModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface GetOffersUseCase {
    fun execute():Flow<Response<OffersModel>>
}