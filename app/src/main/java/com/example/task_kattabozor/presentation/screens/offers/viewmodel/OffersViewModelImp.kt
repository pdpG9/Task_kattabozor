package com.example.task_kattabozor.presentation.screens.offers.viewmodel

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
class OffersViewModelImp @Inject constructor(private val getOffersUseCase: GetOffersUseCase) :
    ViewModel(), OffersViewModel {
    override val offersLiveData = MutableLiveData<List<Offer>>()
    override val moveToInfoScreenLiveData = MutableLiveData<Offer>()

    init {
        getOffersUseCase.execute()
            .onEach { it.body()?.let { offersModel -> offersLiveData.value = offersModel.offers } }
            .launchIn(viewModelScope)
    }

    override fun selectOffer(offer: Offer) {
        moveToInfoScreenLiveData.value = offer
    }
}