package com.sample.kotlinquizchallenge

/*
*
* Write a higher-order function that can convert between Celsius and Fahrenheit.
*
* convertTemperature(25.0, celsiusToFahrenheit) //needs to be a higher order function
* convertTemperature(98.6, fahrenheitToCelsius)
*
* // Expected Output
* 25.0 → 77.0
* 98.6 → 37.0
* */

fun main() {
    println(convertTemperature(25.0, celsiusToFahrenheit))
    println(convertTemperature(98.6, fahrenheitToCelsius)) 
}

fun convertTemperature(value: Double, conversion: (Double) -> Double): Double {
    return conversion(value)
}

val celsiusToFahrenheit: (Double) -> Double = { c -> (c * 9 / 5) + 32 }
val fahrenheitToCelsius: (Double) -> Double = { f -> (f - 32) * 5 / 9 }