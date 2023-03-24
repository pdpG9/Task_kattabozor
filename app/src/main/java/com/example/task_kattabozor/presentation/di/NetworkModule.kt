package com.example.task_kattabozor.presentation.di

import android.content.Context
import com.example.task_kattabozor.data.network.api.KattabozorApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @[Provides Singleton]
    fun provideOkHTTPClient(@ApplicationContext context: Context): OkHttpClient =
        OkHttpClient.Builder().build()

    @[Provides Singleton]
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://www.kattabozor.uz")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    @[Provides Singleton]
    fun provideKattabozorApi(retrofit: Retrofit):KattabozorApi =retrofit.create(KattabozorApi::class.java)
}