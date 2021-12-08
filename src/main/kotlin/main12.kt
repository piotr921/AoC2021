// RESULT= {1=79, 5=71, 3=52, 2=42, 4=56}
// max achievment: 1 641 681 081

// 80 -> 346063

//1 -> 1401
//2 -> 1191
//3 -> 1154
//4 -> 1034
//5 -> 950
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

