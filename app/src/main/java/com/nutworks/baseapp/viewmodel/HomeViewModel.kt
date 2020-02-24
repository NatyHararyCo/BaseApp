package com.nutworks.baseapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.nutworks.baseapp.api.response.Result
import com.nutworks.baseapp.repo.HomeRepo

class HomeViewModel : BaseViewModel() {
    private val homeRepo : HomeRepo = HomeRepo()

//    val personsLiveData : LiveData<PersonResponse> = liveData(Dispatchers.IO){
//        val retrievedData = homeRepo.getPersons("")
//        emit(retrievedData)
//    }

    fun getPersonsFromRepo(): MutableLiveData<ArrayList<Result?>> {
        return homeRepo.getPersonsFromServer()
    }
}