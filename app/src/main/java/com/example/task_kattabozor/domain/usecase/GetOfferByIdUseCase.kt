package com.example.task_kattabozor.domain.usecase

import com.example.task_kattabozor.data.network.models.Offer
import kotlinx.coroutines.flow.Flow

interface GetOfferByIdUseCase {
    fun execute(id:Int):Flow<Offer>
}