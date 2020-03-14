package com.nutworks.baseapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.nutworks.baseapp.api.response.Result
import com.nutworks.baseapp.repo.HomeRepo
import kotlinx.coroutines.Dispatchers

class HomeViewModel : BaseViewModel() {
    private val homeRepo: HomeRepo = HomeRepo()

    fun getPersonsFromRepo(page : Int): LiveData<ArrayList<Result?>> {

        return liveData(Dispatchers.IO) {
            val retrievedData = homeRepo.getPersonsFromServer("", page)
            emit(retrievedData.results!!)
        }
    }
}