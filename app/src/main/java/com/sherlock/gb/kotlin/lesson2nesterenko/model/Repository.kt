package com.sherlock.gb.kotlin.lesson2nesterenko.model

interface Repository {
    fun getWeatherFromServer():Weather
    fun getWorldWeatherFromLocalStorage():Weather

}