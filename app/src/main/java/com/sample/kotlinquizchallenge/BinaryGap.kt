package com.sample.kotlinquizchallenge

/*
* Find the longest sequence of consecutive zeros in binary representation surrounded by ones.
*
* // Input
* findBinaryGap(9)   // Binary: 1001
* findBinaryGap(529) // Binary: 1000010001
* findBinaryGap(32)  // Binary: 100000
*
* // Expected Output
* 9 → 2
* 529 → 4
* 32 → 0 (no gap surrounded by ones)
* */

fun main() {
    println(findBinaryGap(9))
    println(findBinaryGap(529))
    println(findBinaryGap(32))
}

fun findBinaryGap(n: Int): Int {
    val binary = n.toString(2)
    var maxGap = 0
    var currentGap = 0
    var isCounting = false

    for (bit in binary) {
        when (bit) {
            '1' -> {
                if (isCounting) {
                    maxGap = maxOf(maxGap, currentGap)
                    currentGap = 0
                } else {
                    isCounting = true
                }
            }
            '0' -> if (isCounting) currentGap++
        }
    }

    return maxGap
}