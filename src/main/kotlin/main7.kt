fun main(args: Array<String>) {
    println("Hello Task 7!")

    val randomNumbers = args[0].split(",")
    val allFields = args.copyOfRange(1, args.size).mapIndexed { index: Int, value: String -> BoardField(index, value) }
    val allBoards = allFields.windowed(25, 25).map { list -> Board(list) }

    var firstWinningNumber = 0
    var wonIndex = 0
    for (nextNumber in randomNumbers) {
        allBoards.forEach { board -> board.fields.forEach { bf -> bf.checkNumber(nextNumber) } }
        val wonList = allBoards.map { board -> board.hasWon() }

        wonIndex = wonList.indexOf(true)
        if (wonList.any { it }) {
            firstWinningNumber = nextNumber.toInt()
            break
        }
    }

    println("firstWinningNumber=$firstWinningNumber")
    println("wonIndex=$wonIndex")

    val sumOfUncheckedElements = allBoards[wonIndex]
        .fields
        .filter { f -> !f.checked }
        .sumOf { bf -> bf.fieldNumber.toInt() }
    println("sumOfUncheckedElements=$sumOfUncheckedElements")

    val result = firstWinningNumber * sumOfUncheckedElements
    println("RESULT = $result")
}