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