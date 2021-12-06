import java.io.File

fun main(args: Array<String>) {
    println("Hello Task 5!")

    val mutableList = mutableListOf<String>()
    File("/Users/psekula/Workspace/AoC2021/src/main/resources/5_input.txt")
        .forEachLine { mutableList.add(it) }

    val reportAnalizer = mutableListOf<ByteCount>(
        ByteCount(), ByteCount(), ByteCount(), ByteCount(),
        ByteCount(), ByteCount(), ByteCount(), ByteCount(),
        ByteCount(), ByteCount(), ByteCount(), ByteCount()
    )

    for (index in mutableList.indices) {
        val number = mutableList[index]
        number.forEachIndexed { i, value ->
            when (value) {
                '0' -> reportAnalizer[i].add0()
                '1' -> reportAnalizer[i].add1()
            }
        }
    }
    reportAnalizer.forEach { c -> println(c) }

    var moreFrequent = ""
    var lessFrequent = ""
    reportAnalizer.forEach {c -> moreFrequent = moreFrequent.plus(c.moreFrequentValue())}
    reportAnalizer.forEach {c -> lessFrequent = lessFrequent.plus(c.lessFrequentValue())}
    println("More frequent: $moreFrequent")
    println("Less frequent: $lessFrequent")

    val gammaRate = moreFrequent.toInt(2)
    val epsilonRate = lessFrequent.toInt(2)
    val result = gammaRate * epsilonRate

    println("Gamma Rate: $gammaRate; Epsilon Rate: $epsilonRate; RESULT=$result")
}

