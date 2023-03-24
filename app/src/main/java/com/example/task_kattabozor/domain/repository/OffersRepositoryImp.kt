package com.example.task_kattabozor.domain.repository

import com.example.task_kattabozor.data.network.api.KattabozorApi
import com.example.task_kattabozor.data.network.models.OffersModel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Response
import javax.inject.Inject

class OffersRepositoryImp @Inject constructor(private  val api: KattabozorApi):OffersRepository{
    override fun getAllOffers(): Flow<Response<OffersModel>> = callbackFlow {
        trySend(api.getOffers())
        awaitClose()
    }
}