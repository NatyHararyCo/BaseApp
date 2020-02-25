package com.nutworks.baseapp.api

import com.nutworks.baseapp.api.response.PersonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi{

    @GET("api/people/")
    suspend fun getStarWarsPeople(
        @Query("search") search: String): PersonResponse
}