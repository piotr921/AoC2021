// wrong: 17064
// wrong: 56248 - too low ?
// wrong: 64169 - too high
// wrong: 55517 - ?
// wrong: 69776
fun main(args: Array<String>) {
    println("Hello Task 7!")

    val randomNumbers = args[0].split(",")
    val allFields = args.copyOfRange(1, args.size).mapIndexed { index: Int, value: String -> BoardField(index, value) }

    var index = 0
    var boardsSummary = mutableListOf<Board>()
    while (boardsSummary.size < 1) {
        println("Checking for index: $index")
        allFields.forEach { f -> f.checkNumber(randomNumbers[index]) }

        boardsSummary = (0..99)
            .map { i -> Board(allFields.subList(25 * i, (25 * i) + 25)) }
            .filter { b -> b.hasWon() }
            .toMutableList()

        index++
    }

    val multiplier = randomNumbers[index - 1].toInt()

    val sumOfUncheckedElements = boardsSummary
        .filter { b -> b.hasWon() }
        .flatMap { b -> b.fields }
        .filter { f -> !f.checked }
        .sumOf { bf -> bf.fieldNumber.toInt() }

    println("sumOfUncheckedElements: $sumOfUncheckedElements")
    println("multiplier: $multiplier")

    val result = multiplier * sumOfUncheckedElements
    println("RESULT = $result")

}

class Board(val fields: List<BoardField>) {
    fun hasWon(): Boolean {
        var won = false
        for (i in 0..4) {
            if (checkRow(i))
                won = true

            if (checkColumn(i))
                won = true
        }
        return won
    }

    private fun checkRow(i: Int) = fields[i * 5].checked &&
            fields[(i * 5) + 1].checked &&
            fields[(i * 5) + 2].checked &&
            fields[(i * 5) + 3].checked &&
            fields[(i * 5) + 4].checked

    private fun checkColumn(i: Int) = fields[i].checked &&
            fields[i + (1 * 5)].checked &&
            fields[i + (2 * 5)].checked &&
            fields[i + (3 * 5)].checked &&
            fields[i + (4 * 5)].checked
}

class BoardField(
    private val index: Int,
    val fieldNumber: String
) {
    var checked: Boolean = false

    fun checkNumber(other: String) {
        if (fieldNumber == other) {
            checked = true
        }
    }

    override fun toString(): String {
        return "BoardField(index=$index, fieldNumber='$fieldNumber', checked=$checked)"
    }
}
