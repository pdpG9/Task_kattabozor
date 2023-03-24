package com.example.task_kattabozor.data.network.api

import com.example.task_kattabozor.data.network.models.OffersModel
import retrofit2.Response
import retrofit2.http.GET

interface KattabozorApi {

    @GET("/hh/test/api/v1/offers")
    suspend fun getOffers():Response<OffersModel>
}