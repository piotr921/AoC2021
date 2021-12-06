import java.io.File

fun main(args: Array<String>) {
    println("Hello Task 6!")

    val mutableList = mutableListOf<String>()
    File("/home/piotrek/Workspace/AoC2021/src/main/resources/5_input.txt")
        .forEachLine { mutableList.add(it) }

    var remainingElements = mutableList
    var index = 0
    while (remainingElements.size > 1) {
        remainingElements = filterByMoreFrequentByte(remainingElements, index)
        index++
    }

    val co2ScrubberRating = remainingElements[0].toInt(2)
    println("co2ScrubberRating: $co2ScrubberRating")

    var remainingElements2 = mutableList
    var index2 = 0
    while (remainingElements2.size > 1) {
        remainingElements2 = filterByLessFrequentByte(remainingElements2, index2)
        index2++
    }

    val oxygenGeneratorRating = remainingElements2[0].toInt(2)
    println("oxygenGeneratorRating: $oxygenGeneratorRating")

    val result = co2ScrubberRating * oxygenGeneratorRating
    println("RESULT = $result")
}


fun filterByMoreFrequentByte(input: List<String>, index: Int): MutableList<String> {
    val byteStats = analyzeByte(input, index)
    val filteredValues = input.filter { n -> n[index].toString() == moreFrequentOr1WhenEqual(byteStats) }
    println("Remain: ${filteredValues.size}")
    return filteredValues as MutableList<String>
}

fun moreFrequentOr1WhenEqual(byteStats: ByteCount): String {
    return if(byteStats.moreFrequentValue() == "EQUAL") {
        "1"
    } else {
        byteStats.moreFrequentValue()
    }
}

fun filterByLessFrequentByte(input: List<String>, index: Int): MutableList<String> {
    val byteStats = analyzeByte(input, index)
    val filteredValues = input.filter { n -> n[index].toString() == lessFrequentOr0WhenEqual(byteStats) }
    println("Remain: ${filteredValues.size}")
    return filteredValues as MutableList<String>
}

fun lessFrequentOr0WhenEqual(byteStats: ByteCount): String {
    return if(byteStats.lessFrequentValue() == "EQUAL") {
        "0"
    } else {
        byteStats.lessFrequentValue()
    }
}

private fun analyzeByte(input: List<String>, index: Int): ByteCount {
    val byteStats = ByteCount()
    input.forEach { n ->
        when (n[index]) {
            '0' -> byteStats.add0()
            '1' -> byteStats.add1()
        }
    }
    println("For byte: $index we have: $byteStats")
    return byteStats
}

