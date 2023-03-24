package com.example.task_kattabozor.domain.usecase

import com.example.task_kattabozor.data.network.models.OffersModel
import com.example.task_kattabozor.domain.repository.OffersRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class GetOffersUseCaseImp @Inject constructor(private val repository: OffersRepository):GetOffersUseCase {
    override fun execute(): Flow<Response<OffersModel>> = repository.getAllOffers()
}