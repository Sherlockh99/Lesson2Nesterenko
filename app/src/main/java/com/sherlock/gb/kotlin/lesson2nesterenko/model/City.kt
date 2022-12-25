package com.sherlock.gb.kotlin.lesson2nesterenko.model

data class City(
    val city: String,
    val lat: Double,
    val lon: Double
)

fun getDefaultCity() = City("London", 55.755826, 37.617299900000035)