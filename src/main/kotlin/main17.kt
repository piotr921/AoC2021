fun main(args: Array<String>) {
    println("Hello Task 17!")

    var overallSum = 0
    for (i in args.indices) {
        val sumFromRow = isLocalMinimumInRow(args, i)
            .map { mi -> args[i].substring(mi, mi + 1).toInt() }
            .map { value -> value + 1 } // calc risk level
            .toList()
            .sum()

        println("sumFromRow=$sumFromRow")
        overallSum += sumFromRow
    }

    println("overallSum=$overallSum")
}

private fun isLocalMinimumInRow(area: Array<String>, row: Int): List<Int> {

    var result = mutableListOf<Int>()
    area[row]
        .map { s -> s.toInt() }
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