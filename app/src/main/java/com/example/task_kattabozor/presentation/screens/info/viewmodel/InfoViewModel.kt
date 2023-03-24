package com.example.task_kattabozor.presentation.screens.info.viewmodel

import androidx.lifecycle.LiveData
import com.example.task_kattabozor.data.network.models.Offer

interface InfoViewModel {
    val currentOfferLiveData: LiveData<Offer>
    val moveToBackLiveData: LiveData<Unit>

    fun loadOffer(id: Int)
    fun clickBack()
}