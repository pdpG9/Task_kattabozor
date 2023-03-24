package com.example.task_kattabozor.domain.usecase

import com.example.task_kattabozor.data.network.models.Offer
import com.example.task_kattabozor.domain.repository.OffersRepository
import com.example.task_kattabozor.domain.repository.OffersRepositoryImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class GetOfferByIdUseCaseImp @Inject constructor(private val repository: OffersRepository):GetOfferByIdUseCase {
    override fun execute(id: Int): Flow<Offer> = flow {
        repository.getAllOffers().onEach {
            it.body()?.let {list->
                list.offers.forEach {offer->
                    if (offer.id==id)
                        emit(offer)
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO+ Job()))
    }
}