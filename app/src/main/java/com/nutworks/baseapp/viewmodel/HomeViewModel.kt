package com.nutworks.baseapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.nutworks.baseapp.api.response.Result
import com.nutworks.baseapp.repo.HomeRepo
import kotlinx.coroutines.Dispatchers

class HomeViewModel : BaseViewModel() {
    private val homeRepo : HomeRepo = HomeRepo()

    val personsLiveData :  LiveData<ArrayList<Result?>> = liveData(Dispatchers.IO){
        val retrievedData = homeRepo.getPersonsFromServer("")
        emit(retrievedData.results!!)
    }
}