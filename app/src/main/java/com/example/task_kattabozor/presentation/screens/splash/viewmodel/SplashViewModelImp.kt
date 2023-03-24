package com.example.task_kattabozor.presentation.screens.splash.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImp @Inject constructor() : ViewModel(), SplashViewModel {
    override val moveToOffersScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            delay(2000)
            moveToOffersScreenLiveData.value = Unit
        }
    }
}