package com.sherlock.gb.kotlin.lesson2nesterenko.model

data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0
)


