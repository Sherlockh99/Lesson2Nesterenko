package com.sherlock.gb.kotlin.lesson2nesterenko.viewmodel

import com.sherlock.gb.kotlin.lesson2nesterenko.model.Weather

sealed class AppState {
    object Loading:AppState()
    data class Success(val weatherData:Any):AppState(){
        fun test(){}
    }
    data class Error(val error:Throwable):AppState()
}
