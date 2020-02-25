package com.nutworks.baseapp.repo

import androidx.lifecycle.MutableLiveData
import com.nutworks.baseapp.api.RestApi
import com.nutworks.baseapp.api.response.Result
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class HomeRepo : BaseRepo() {

    private var restApi: RestApi
    private var retrofit =
        Retrofit.Builder().baseUrl("https://swapi.co/") //TODO make this a constant
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    private var persons: MutableLiveData<ArrayList<Result?>> //TODO is this needed?
    private lateinit var client: Retrofit //TODO is this needed?

    init {
        restApi = retrofit.create()
        persons = MutableLiveData() //TODO is this needed?
    }

    //TODO find out a way to handle errors. Alex wrapped the PersonResponse with Response<> so it can see
    //TODO if it is unsuccesful
    suspend fun getPersonsFromServer(personName : String) = restApi.getStarWarsPeople(personName)
}