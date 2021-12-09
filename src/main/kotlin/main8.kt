fun main(args: Array<String>) {
    println("Hello Task 8!")

    val randomNumbers = args[0].split(",")
    val allFields = args.copyOfRange(1, args.size).mapIndexed { index: Int, value: String -> BoardField(index, value) }
    val allBoards = allFields.windowed(25, 25).map { list -> Board(list) }

    var lastWinningNumber = 0
    var notWonIndex = 0
    for (nextNumber in randomNumbers) {
        allBoards.forEach { board -> board.fields.forEach { bf -> bf.checkNumber(nextNumber) } }
        val wonList = allBoards.map { board -> board.hasWon() }

        if (wonList.indexOf(false) > 0) {
            notWonIndex = wonList.indexOf(false)
        }

        if (wonList.all { it }) {
            lastWinningNumber = nextNumber.toInt()
            break
        }
    }

    println("lastWinningNumber=$lastWinningNumber")
    println("notWonIndex=$notWonIndex")

    val sumOfUncheckedElements = allBoards[notWonIndex]
        .fields
        .filter { f -> !f.checked }
        .sumOf { bf -> bf.fieldNumber.toInt() }
    println("sumOfUncheckedElements=$sumOfUncheckedElements")

    val result = lastWinningNumber * sumOfUncheckedElements
    println("RESULT = $result")
}