fun main(args: Array<String>) {
    println("Hello Task TEST!")

    val genA = Fish(79)

    val genB = genA.noOfChildrenList()
    println("No of children: ${genB.size}")
//    genB.forEach { x -> println(x) }

    val genC = genB.flatMap { gb -> gb.noOfChildrenList() }
    println("No of children: ${genC.size}")
//    genC.forEach { x -> println(x) }

    val genD = genC.flatMap { gc -> gc.noOfChildrenList() }
    println("No of children: ${genD.size}")
//    genD .forEach { x -> println(x) }

    val genE = genD.flatMap { gd -> gd.noOfChildrenList() }
    println("No of children: ${genE.size}")
//    genE .forEach { x -> println(x) }

    val genF = genE.flatMap { ge -> ge.noOfChildrenList() }
    println("No of children: ${genF.size}")

    val genG = genF.flatMap { gf -> gf.noOfChildrenList() }
    println("No of children: ${genG.size}")

    val genH = genG.flatMap { gg -> gg.noOfChildrenList() }
    println("No of children: ${genH.size}")

    val genI = genH.flatMap { gh -> gh.noOfChildrenList() }
    println("No of children: ${genI.size}")

    val genJ = genI.flatMap { gi -> gi.noOfChildrenList() }
    println("No of children: ${genJ.size}")

    val firstResult = 1 + 11 + 45 + 120 + 210 + 126 + 84 + 36 + 9
    println("FIRST RESULT = $firstResult")

    var childrenCounter = 0
    var generation = mutableListOf<Fish>()
    generation.add(Fish(79))
    for (i in 79 downTo 0 step 9) {
        childrenCounter += generation.size
        generation = generation.flatMap { g -> g.noOfChildrenList() }.toMutableList()
    }

    println("SECOND RESULT = $childrenCounter")
}

class Fish(private val daysAlive: Int) {

    fun noOfChildrenList(): MutableList<Fish> {
        var result = mutableListOf<Fish>()

        val firstBirth = daysAlive - 9
        for (i in firstBirth downTo 0 step 7) {
            result.add(Fish(i))
        }

        return result
    }

    override fun toString(): String {
        return "Fish(daysAlive=$daysAlive)"
    }
}