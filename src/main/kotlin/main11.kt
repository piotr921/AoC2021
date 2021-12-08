// RESULT= {1=79, 5=71, 3=52, 2=42, 4=56}

const val DAYS = 80

fun main(args: Array<String>) {
    println("Hello Task 11!")

    val result = args[0]
        .split(",")
        .map { s -> s.toInt() }
        .groupingBy { it }
        .eachCount()
        .mapValues { calculateNumberOfFishFromParent(it.key) * it.value }
        .map { it.value }
        .sumBy { it }

    println("RESULT= $result")
}

fun calculateNumberOfFishFromParent(initValue: Int): Int {

    var result = 1
    var generation = calcChildren(initValue)
    result += generation.size

    while (generation.size > 0) {
        generation = generation.flatMap { g -> noOfChildrenList(g) }.toMutableList()
        result += generation.size
    }

    return result
}
fun calcChildren(initValue: Int): MutableList<Int> {
    val result = mutableListOf<Int>()

    for (i in (DAYS - initValue) downTo 0 step 7) {
        // because new fish is appears one day after birth
        if (i - 1 >= 0) {
            result.add(i)
        }
    }

    return result
}

fun noOfChildrenList(daysAlive: Int): MutableList<Int> {
    return if(daysAlive <= 9) {
        emptyList<Int>().toMutableList()
    } else {
        val children = mutableListOf<Int>()
        for (i in daysAlive - 9 downTo 1 step 7) {
            children.add(i)
        }
        children
    }
}
