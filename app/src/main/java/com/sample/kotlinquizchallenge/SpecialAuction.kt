package com.sample.kotlinquizchallenge

/*
*
* Implement an auction bidding system where new bids must be higher than current bid.
*
* // Input
* placeBid(50)  // First bid
* placeBid(30)  // Too low
* placeBid(75)  // Valid higher bid
*
* // Expected Output
* 50 → 50 (accepted)
* 30 → null (rejected)
* 75 → 75 (accepted)
* */

fun main() {
    val auction = Auction()

    println(auction.placeBid(50))
    println(auction.placeBid(30))
    println(auction.placeBid(75))
}

class Auction {
    private var currentBid: Int? = null

    fun placeBid(amount: Int): Int? {
        return if (currentBid == null || amount > currentBid!!) {
            currentBid = amount
            currentBid
        } else {
            null
        }
    }
}