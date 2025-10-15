package com.sample.kotlinquizchallenge

/*
* Model a Tic Tac Toe game with board state and game status.
*
* // Input
* // X _ _
* // O X _
* // O _ X

* // Expected Output
* gameState.status → GameStatus.X_WINS
* gameState.currentPlayer → null (game ended)
* */

fun main() {
    val game = TicTacToe()
    game.play(0, 0)
    game.play(1, 0)
    game.play(1, 1)
    game.play(2, 0)
    game.play(2, 2)

    game.printBoard()
    println("Game Status: ${game.status}")
    println("Current Player: ${game.currentPlayer}")
}

enum class Player { X, O }
enum class GameStatus { IN_PROGRESS, X_WINS, O_WINS, DRAW }

class TicTacToe {
    private val board = Array(3) { arrayOfNulls<Player>(3) }
    var currentPlayer: Player? = Player.X
        private set
    var status: GameStatus = GameStatus.IN_PROGRESS
        private set

    fun play(row: Int, col: Int): Boolean {
        if (status != GameStatus.IN_PROGRESS || board[row][col] != null) return false

        board[row][col] = currentPlayer
        updateGameStatus()

        if (status == GameStatus.IN_PROGRESS) {
            currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
        } else {
            currentPlayer = null
        }
        return true
    }

    private fun updateGameStatus() {
        val lines = mutableListOf<List<Player?>>()

        for (i in 0..2) {
            lines.add(board[i].toList())
            lines.add(listOf(board[0][i], board[1][i], board[2][i]))
        }

        lines.add(listOf(board[0][0], board[1][1], board[2][2]))
        lines.add(listOf(board[0][2], board[1][1], board[2][0]))

        when {
            lines.any { it.all { cell -> cell == Player.X } } -> status = GameStatus.X_WINS
            lines.any { it.all { cell -> cell == Player.O } } -> status = GameStatus.O_WINS
            board.all { row -> row.all { it != null } } -> status = GameStatus.DRAW
            else -> status = GameStatus.IN_PROGRESS
        }
    }

    fun printBoard() {
        for (row in board) {
            println(row.joinToString(" ") { it?.name ?: "_" })
        }
        println()
    }
}