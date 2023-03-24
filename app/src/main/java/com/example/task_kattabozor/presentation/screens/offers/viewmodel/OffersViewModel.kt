package com.example.task_kattabozor.presentation.screens.offers.viewmodel

import androidx.lifecycle.LiveData
import com.example.task_kattabozor.data.network.models.Offer

interface OffersViewModel {
    val offersLiveData: LiveData<List<Offer>>
    val moveToInfoScreenLiveData:LiveData<Offer>
    fun selectOffer(offer: Offer)
}