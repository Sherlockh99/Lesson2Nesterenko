package com.sherlock.gb.kotlin.lesson2nesterenko.model

class RepositoryImpl:Repository {
    override fun getWeatherFromServer():Weather {
        Thread.sleep(2000L)
        return Weather()// эмуляция ответа
    }

    override fun getWorldWeatherFromLocalStorage():Weather {
        return Weather()// эмуляция ответа
    }


}