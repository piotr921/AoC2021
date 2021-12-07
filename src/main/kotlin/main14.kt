import kotlin.math.abs

fun main(args: Array<String>) {
    println("Hello Task 14!")

    val intArgs = args[0].split(",")
        .map { a -> a.toInt() }
        .toList()

    println(intArgs.maxOrNull())
    val maxOrNull = intArgs.maxOrNull()?.toInt()

    var fuelBurned = mutableListOf<Int>()
    for (i in 0..maxOrNull!!) {
        fuelBurned.add(i, intArgs.sumOf { arg -> (1..abs(i - arg)).sum() })
    }

    fuelBurned.forEach { f -> println(f) }
    println("RESULT = ${fuelBurned.minOrNull()}")
}