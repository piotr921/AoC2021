class ByteCount {
    private var zeros: Int = 0
    private var ones: Int = 0

    fun add0() {
        zeros += 1
    }

    fun add1() {
        ones += 1
    }

    fun moreFrequentValue(): String {
        return when (zeros - ones) {
            in 1 .. Int.MAX_VALUE -> "0"
            0 -> "EQUAL"
            else -> "1"
        }
    }

    fun lessFrequentValue(): String {
        return when (moreFrequentValue()) {
            "1" -> "0"
            "0" -> "1"
            else -> "EQUAL"
        }
    }

    override fun toString(): String {
        return "ByteCount(zeros=$zeros, ones=$ones)"
    }
}