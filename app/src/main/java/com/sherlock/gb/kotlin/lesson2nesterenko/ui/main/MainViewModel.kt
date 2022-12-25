package com.sherlock.gb.kotlin.lesson2nesterenko.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sherlock.gb.kotlin.lesson2nesterenko.model.Repository
import com.sherlock.gb.kotlin.lesson2nesterenko.model.RepositoryImpl
import com.sherlock.gb.kotlin.lesson2nesterenko.model.Weather
import com.sherlock.gb.kotlin.lesson2nesterenko.viewmodel.AppState
import java.lang.Thread.sleep

class MainViewModel (
    private val liveData:MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryImpl = RepositoryImpl()
        ): ViewModel() {

    fun getData():LiveData<AppState>{
        return liveData
    }

    fun getWeather() {
        Thread{
            liveData.postValue(AppState.Loading)

            var i = (0..20).random()
            if(i>10) {
                //liveData.postValue(AppState.Success(Weather()))
                liveData.postValue(AppState.Success(repository.getWeatherFromServer()))
            }else{
                //liveData.postValue(AppState.Error(IllegalAccessException()))
                liveData.postValue(AppState.Success(repository.getWorldWeatherFromLocalStorage()))
            }
        }.start()
    }

}