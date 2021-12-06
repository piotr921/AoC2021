// 12648 - too low
fun main(args: Array<String>) {
    println("Hello Task 8!")

    val randomNumbers = args[0].split(",")
    val allFields = args.copyOfRange(1, args.size).mapIndexed { index: Int, value: String -> BoardField(index, value) }

    var index = 0
    var boardsSummary = mutableListOf<Board>()

    while (boardsSummary.size != 1) {
        println("Checking for index: $index")
        allFields.forEach { f -> f.checkNumber(randomNumbers[index]) }

        boardsSummary = (0..99)
            .map { i -> Board(allFields.subList(25 * i, (25 * i) + 25)) }
            .filter { b -> !b.hasWon() }
            .toMutableList()

        println("Still ${boardsSummary.size} not won")
        index++
    }

    val multiplier = randomNumbers[index - 1].toInt()

    boardsSummary
        .flatMap { bs -> bs.fields }
        .forEach { bs -> println(bs) }

    val sumOfUncheckedElements = boardsSummary
        .filter { b -> !b.hasWon() }
        .flatMap { b -> b.fields }
        .filter { f -> !f.checked }
        .sumOf { bf -> bf.fieldNumber.toInt() }

    println("sumOfUncheckedElements: $sumOfUncheckedElements")
    println("multiplier: $multiplier")

    val result = multiplier * sumOfUncheckedElements
    println("RESULT = $result")

}