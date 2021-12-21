// too high
fun main(args: Array<String>) {
    println("Let's play game!")

    var player1Position = 10
    var player2Position = 7
    var player1Points = 0
    var player2Points = 0

    var lostPoints = 0
    var diceRolls = 0

    val points = IntRange(1, 999).map { it.rem(100) }.map { fixZeros(it) }.windowed(3, 3, true).map { list -> list.sum() }
    points.forEachIndexed { index, pts ->
        val playerId = index.rem(2)
        if (playerId == 0) {
            player1Position = calcPosition(player1Position + pts)
            player1Points += player1Position
        } else {
            player2Position = calcPosition(player2Position + pts)
            player2Points += player2Position
        }
    }
    println("player1Points=$player1Points")
    println("player2Points=$player2Points")
}

private fun fixZeros(number: Int): Int {
    return if (number == 0) {
        100
    } else {
        number
    }
}

private fun calcPosition(playerScore: Int): Int {
    return if (playerScore.rem(10) != 0) {
        playerScore.rem(10)
    } else {
        10
    }
}