package com.sample.kotlinquizchallenge

/*
* Find the most frequently occurring word, ignoring common stop words.
*
* // Input
* findMostCommonWord("The sun shines and the sky is blue and clear")
*
* // Expected Output
* "The sun shines and the sky is blue and clear" → "and"
*
* */

fun main() {
    println(findMostCommonWord("The sun shines and the sky is blue and clear"))
    println(findMostCommonWord("I saw the sea and sea saw the sky and sky saw me"))
}

fun findMostCommonWord(text: String): String {

    // I have found this words in google
    val stopWords = setOf(
        "the", "is", "a", "an", "and", "or", "in", "on", "at", "to", "for", "of", "by", "with", "as"
    )

    val words = text
        .lowercase()
        .split("\\W+".toRegex())
        .filter { it.isNotBlank() && it !in stopWords }

    if (words.isEmpty()) return ""

    val frequencyMap = words.groupingBy { it }.eachCount()

    return frequencyMap.maxByOrNull { it.value }?.key ?: ""
}