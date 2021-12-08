const val DAYS = 256

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
    var generation = LanternFishParent(initValue).calcChildren()
    result += generation.size

    while (generation.size > 0) {
        generation = generation.flatMap { g -> g.noOfChildrenList() }.toMutableList()
        result += generation.size
    }

    return result
}

class LanternFishParent(private val initValue: Int) {

    fun calcChildren(): MutableList<LanternFish> {
        val result = mutableListOf<LanternFish>()

        for (i in (DAYS - initValue) downTo 0 step 7) {
            // because new fish is appears one day after birth
            if (i - 1 >= 0) {
                result.add(LanternFish(i))
            }
        }

        return result
    }

    override fun toString(): String {
        return "LanternFishParent(initValue=$initValue)"
    }
}

class LanternFish(private val daysAlive: Int) {

    fun noOfChildrenList(): MutableList<LanternFish> {
        return if(daysAlive <= 9) {
            emptyList<LanternFish>().toMutableList()
        } else {
            val children = mutableListOf<LanternFish>()
            for (i in daysAlive - 9 downTo 1 step 7) {
                children.add(LanternFish(i))
            }
            children
        }
    }

    override fun toString(): String {
        return "LanternFish(daysAlive=$daysAlive)"
    }
}