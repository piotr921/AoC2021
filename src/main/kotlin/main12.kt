import java.lang.reflect.TypeVariable

// RESULT= {1=79, 5=71, 3=52, 2=42, 4=56}
// max achievment: 1 641 681 081

// 80 -> 346063

//1 -> 1401
//2 -> 1191
//3 -> 1154
//4 -> 1034
//5 -> 950
fun main(args: Array<String>) {
    println("Hello Task 12!")

    val inputMap = args[0]
        .split(",")
        .map { s -> s.toInt() }
        .groupingBy { it }
        .eachCount()

    val fish = mutableMapOf<Int, MutableList<Int>>()
    inputMap.keys.forEach { k -> fish.putIfAbsent(k, mutableListOf(k)) }
    for (day in 1..18) {
        for (startAge in fish.keys) {
            val children = fish[startAge]
            for (j in 0 until (children?.size ?: 0)) {
                val newAge = calcNewAge(children?.get(j) ?: -1)
                children?.set(j, newAge)
                if (newAge == 0) {
                    children?.add(8)
                }
            }
            if (children != null) {
                fish[startAge] = children
            }
        }
    }

    println(fish)

    val result = inputMap
        .map { (k, v) -> (fish[k]?.size ?: 0) * v }
        .sum()

//    val result = args[0]
//        .split(",")
//        .map { s -> s.toInt() }
//        .groupingBy { it }
//        .eachCount()
//        .mapValues { calculateNumberOfFishFromParent(it.key) * it.value }
//        .map { it.value }
//        .sumBy { it }
//
    println("RESULT= $result")
}

private fun calcNewAge(oldAge: Int): Int {
    val newAge = oldAge - 1
    return if (newAge < 0) {
        6
    } else {
        newAge
    }
}

