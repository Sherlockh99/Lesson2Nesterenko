package com.sherlock.gb.kotlin.lesson2nesterenko.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sherlock.gb.kotlin.lesson2nesterenko.model.Weather
import com.sherlock.gb.kotlin.lesson2nesterenko.viewmodel.AppState
import java.lang.Thread.sleep

class MainViewModel (
    private val liveData:MutableLiveData<AppState> = MutableLiveData()
        ): ViewModel() {

    fun getData():LiveData<AppState>{
        return liveData
    }

    fun getWeather() {
        Thread{
            liveData.postValue(AppState.Loading)
            sleep(2000L)
            var i = (0..100).random()
            if(i>1) {
                //liveData.postValue(AppState.Success(Weather()))
                liveData.postValue(AppState.Success(Any()))
            }else{
                liveData.postValue(AppState.Error(IllegalAccessException()))
            }
        }.start()
    }

}