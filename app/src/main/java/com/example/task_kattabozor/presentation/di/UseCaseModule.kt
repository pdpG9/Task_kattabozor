package com.example.task_kattabozor.presentation.di

import com.example.task_kattabozor.domain.usecase.GetOfferByIdUseCase
import com.example.task_kattabozor.domain.usecase.GetOfferByIdUseCaseImp
import com.example.task_kattabozor.domain.usecase.GetOffersUseCase
import com.example.task_kattabozor.domain.usecase.GetOffersUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @[Binds Singleton]
    fun bindGetOffersUseCase(getOffersUseCaseImp: GetOffersUseCaseImp): GetOffersUseCase
    @[Binds Singleton]
    fun bindGetOfferByIdUseCase(getOfferByIdUseCaseImp: GetOfferByIdUseCaseImp):GetOfferByIdUseCase
}