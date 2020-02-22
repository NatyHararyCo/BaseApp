package com.nutworks.baseapp.repo

import androidx.lifecycle.MutableLiveData
import com.nutworks.baseapp.api.RestApi
import com.nutworks.baseapp.api.response.PersonResponse
import com.nutworks.baseapp.api.response.Result
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class HomeRepo : BaseRepo() {

    private var restApi: RestApi
    private var retrofit = Retrofit.Builder().baseUrl("https://swapi.co/") //TODO make this a constant
        .addConverterFactory(GsonConverterFactory.create()).build()
    var persons : MutableLiveData<List<Result?>>? = null
    private lateinit var client : Retrofit

    init{
        restApi = retrofit.create()
        persons = MutableLiveData()

    }

//    suspend fun getPersons(personName : String) = restApi.getStarWarsPeople(personName)

    fun getPersonsFromServer() : MutableLiveData<List<Result?>>? {
        restApi.getStarWarsPeople("").enqueue(object : Callback<PersonResponse>{
            override fun onResponse(
                call: Call<PersonResponse>,
                response: Response<PersonResponse>
            ) {
                persons?.value = response.body()?.results
            }

            override fun onFailure(call: Call<PersonResponse>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        return persons
    }
}