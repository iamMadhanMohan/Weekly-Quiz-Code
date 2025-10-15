package com.sample.kotlinquizchallenge

/*
*
* Write a function that takes the number of notifications a user has received and returns a summary string.
*
* Example
* -> 0 -> No Notifications
* -> 3-99 -> You have 3 Notifications
* -> 100+ -> You have Notifications 99+
* */

fun main() {

    println(notificationsSummary(0))
    println(notificationsSummary(1))
    println(notificationsSummary(12))
    println(notificationsSummary(99))
    println(notificationsSummary(100))
    println(notificationsSummary(123))
}

fun notificationsSummary(numberOfNotifications: Int): String = when(numberOfNotifications) {
        0 -> "No Notifications"
        in 1..99 -> "You have $numberOfNotifications Notifications"
        else -> "You have notifications 99+"
    }