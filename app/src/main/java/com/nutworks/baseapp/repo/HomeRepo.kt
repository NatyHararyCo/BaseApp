package com.nutworks.baseapp.repo

import com.nutworks.baseapp.api.RestApi
import com.nutworks.baseapp.tools.API_BASE_LINK
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class HomeRepo : BaseRepo() {

    private var restApi: RestApi
    private var retrofit =
        Retrofit.Builder().baseUrl(API_BASE_LINK)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    init {
        restApi = retrofit.create()
    }

    //TODO find out a way to handle errors. Alex wrapped the PersonResponse with Response<> so it can see
    //TODO if it is unsuccesful
    suspend fun getPersonsFromServer(personName : String, page : Int) = restApi.getStarWarsPeople(personName, page)
}