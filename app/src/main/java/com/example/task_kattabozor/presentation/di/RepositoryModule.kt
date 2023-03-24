package com.example.task_kattabozor.presentation.di

import com.example.task_kattabozor.domain.repository.OffersRepository
import com.example.task_kattabozor.domain.repository.OffersRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @[Binds Singleton]
    fun bindOffersRepository(offersRepositoryImp: OffersRepositoryImp): OffersRepository
}