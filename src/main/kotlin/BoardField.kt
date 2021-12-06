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