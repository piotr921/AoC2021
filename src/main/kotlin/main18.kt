fun main(args: Array<String>) {
    println("Hello Task 18!")

    val test = arrayOf(
        "2199943210",
        "3987894921",
        "9856789892",
        "8767896789",
        "9899965678"
    )

    test
        .mapIndexed { index, _ -> findMinimumsInRow(test, index) }
        .mapIndexed { index, list -> calcBasin(test, index, list[0]) }
        .forEach { r -> println(r) }

}

private fun calcBasin(area: Array<String>, row: Int, col: Int): Int {
    val wholeRow = mapRowToInt(area[row])
    wholeRow.forEach { println(it) }

    // go right
    val rightPart = mutableListOf<Int>()
    for (i in col + 1 until wholeRow.size) {
        if (wholeRow[i] == 9) {
            break
        } else {
            rightPart.add(wholeRow[i])
        }
    }
    println("rightPart:")
    rightPart.forEach { println(it) }

    // go left
    val leftPart = mutableListOf<Int>()
    for (i in 0 until col) {
        if (wholeRow[i] == 9) {
            break
        } else {
            leftPart.add(wholeRow[i])
        }
    }
    println("leftPart:")
    leftPart.forEach { println(it) }

    // go down
    val downPart = mutableListOf<Int>()
    for (i in row + 1 until area.size) {
        val checkedRow = mapRowToInt(area[i])
        if (checkedRow[row] == 9) {
            break
        } else {
            downPart.add(checkedRow[i])
        }
    }
    println("leftPart:")
    leftPart.forEach { println(it) }

    return 0
}

private fun mapRowToInt(stringRow: String): List<Int> {
    val intRow = mutableListOf<Int>()
    for (i in 0..9) {
        intRow.add(stringRow.substring(i, i + 1).toInt())
    }
    return intRow
}

private fun findMinimumsInRow(area: Array<String>, row: Int): List<Int> {

    var result = mutableListOf<Int>()
    area[row]
        .map { it.toInt() }
        .forEachIndexed { col, _ ->
            run {
                if (isLocalMinimum(area, row, col)) {
                    result.add(col)
                }
            }
        }

    return result
}

private fun isLocalMinimum(area: Array<String>, row: Int, col: Int): Boolean {

    val toCompare = area[row].substring(col, col + 1).toInt()

    val neighbours = mutableListOf<Int>()
    if (col - 1 >= 0) {
        neighbours.add(area[row].substring(col - 1, col).toInt())
    }

    if (col + 1 < area[row].length) {
        neighbours.add(area[row].substring(col + 1, col + 2).toInt())
    }

    if (row - 1 >= 0) {
        neighbours.add(area[row - 1].substring(col, col + 1).toInt())
    }

    if (row + 1 < area.size) {
        neighbours.add(area[row + 1].substring(col, col + 1).toInt())
    }

    var isSmallest = true

    neighbours.forEach { n ->
        if (n <= toCompare) {
            isSmallest = false
        }
    }

    return isSmallest
}