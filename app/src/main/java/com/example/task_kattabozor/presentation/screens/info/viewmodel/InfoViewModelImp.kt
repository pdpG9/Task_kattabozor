package com.example.task_kattabozor.presentation.screens.info.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task_kattabozor.data.network.models.Offer
import com.example.task_kattabozor.domain.usecase.GetOffersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class InfoViewModelImp @Inject constructor(private val getOffersUseCase: GetOffersUseCase) :
    ViewModel(), InfoViewModel {
    override val currentOfferLiveData = MutableLiveData<Offer>()
    override val moveToBackLiveData = MutableLiveData<Unit>()

    override fun loadOffer(id: Int) {
        getOffersUseCase.execute().onEach {
            it.body()?.let {offersModel ->
            offersModel.offers.forEach {offer-> if (offer.id==id) currentOfferLiveData.value = offer }
            }
        }.launchIn(viewModelScope)
    }

    override fun clickBack() {
        moveToBackLiveData.value = Unit
    }
}