class Board(val fields: List<BoardField>) {

    fun hasWon(): Boolean {
        return checkRow()
                || checkColumn(0)
                || checkColumn(1)
                || checkColumn(2)
                || checkColumn(3)
                || checkColumn(4)
    }

    private fun checkRow(): Boolean {
        return fields.windowed(5, 5)
            .any { row -> row.all { f -> f.checked } }
    }

    private fun checkColumn(first: Int): Boolean {
        return fields[first].checked &&
                fields[first + (1 * 5)].checked &&
                fields[first + (2 * 5)].checked &&
                fields[first + (3 * 5)].checked &&
                fields[first + (4 * 5)].checked
    }

    override fun toString(): String {
        return "Board(fields=$fields)"
    }
}