// 169463 - too low
// 188287 - too low
fun main(args: Array<String>) {
    println("Hello Task 11!")

    val result = args[0]
        .split(",")
        .map { s -> s.toInt() }
        .groupingBy { it }
        .eachCount()
        .mapValues { calculateNumberOfFishFromParent(80 - it.key) * it.value }
        .map { it.value }
        .sumBy { it }

    println("RESULT= $result")
}

fun calculateNumberOfFishFromParent(parentDaysAlive: Int): Int {
    var childrenCounter = 0
    var generation = mutableListOf<LanternFish>()
    generation.add(LanternFish(parentDaysAlive))
    for (i in parentDaysAlive downTo 0 step 9) {
        childrenCounter += generation.size
        generation = generation.flatMap { g -> g.noOfChildrenList() }.toMutableList()
    }

    println("From 1 fish with ${80 - parentDaysAlive} days to delivery at start will grow to: $childrenCounter fish and the end")
    return childrenCounter
}

class LanternFish(private val daysAlive: Int) {

    fun noOfChildrenList(): MutableList<LanternFish> {
        var result = mutableListOf<LanternFish>()

        val firstBirth = daysAlive - 9
        for (i in firstBirth downTo 0 step 7) {
            result.add(LanternFish(i))
        }

        return result
    }

    override fun toString(): String {
        return "LanternFish(daysAlive=$daysAlive)"
    }
}