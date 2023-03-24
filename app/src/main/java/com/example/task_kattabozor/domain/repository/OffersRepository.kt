package com.example.task_kattabozor.domain.repository

import com.example.task_kattabozor.data.network.models.OffersModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface OffersRepository{
fun getAllOffers(): Flow<Response<OffersModel>>
}