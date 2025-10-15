package com.sample.kotlinquizchallenge

/*
*
* Create a function that calculates movie ticket price based on age and showtime.
*
* // Input
* calculateTicketPrice(age = 25, isMatinee = false) // Adult, evening
* calculateTicketPrice(age = 70, isMatinee = true)  // Senior, matinee
* calculateTicketPrice(age = 8, isMatinee = false)  // Child, evening
*
* // Expected Output
* 25, false → 15
* 70, true → 8
* 8, false → 8
*
* */

fun main() {
    println(calculateTicketPrice(25, false))
    println(calculateTicketPrice(70, true))
    println(calculateTicketPrice(8, false))
}

fun calculateTicketPrice(age: Int, isMatinee: Boolean): Int {
    return when {
        age < 13 -> if (isMatinee) 6 else 8
        age >= 65 -> if (isMatinee) 8 else 10
        else -> if (isMatinee) 12 else 15
    }
}