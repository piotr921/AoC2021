// 732 - too high
fun main(args: Array<String>) {
    println("Hello Task 25!")

    val cleaned = args.filter { a -> (a != "fold") && (a != "along") }
    val indexOfFirst = cleaned.indexOfFirst { a -> a.startsWith("x") || a.startsWith("y") }
    val folds = cleaned.subList(indexOfFirst, cleaned.size)

    val initData = cleaned.subList(0, indexOfFirst).map { arg -> arg.split(",").map { s -> s.toInt() } }.map { l -> Point(l[0], l[1]) }
//    val foldY = folds[0].last().toString().toInt()
//    val afterFoldY = foldY(initData, foldY)
    println("maxX=${maxX(initData)}")

    val foldX = folds[0].substringAfter("=").toInt()
    println("foldX=$foldX")

    val afterFoldX = foldX(initData, foldX)
//    afterFoldX.forEach{ println(it)}

    val size = afterFoldX.size
    println("RESULT=$size")
}

fun foldY(initData: List<Point>, fold: Int): List<Point> {
    val maxY = maxY(initData)
    val notChangedTop = initData.filter { p -> p.y < fold }

    val bottomMapped = initData
        .filter { p -> p.y > fold }
        .map { point -> Point(point.x, maxY - point.y) }
        .filter { point -> !notChangedTop.contains(point) }

    return notChangedTop + bottomMapped
}

fun foldX(initData: List<Point>, fold: Int): List<Point> {
    val maxX = maxX(initData)
    val notChangedRight = initData.filter { p -> p.x < fold }

    val leftMapped = initData
        .filter { p -> p.x > fold }
        .map { point -> Point(maxX - point.x, point.y) }
        .filter { point -> !notChangedRight.contains(point) }

    return notChangedRight + leftMapped
}

private fun maxY(data: List<Point>) : Int {
     return data.map { p -> p.y }.maxOrNull()?.or(0)!!
}

private fun maxX(data: List<Point>) : Int {
    return data.map { p -> p.x }.maxOrNull()?.or(0)!!
}

class Point(val x: Int, val y: Int) {

    override fun toString(): String {
        return "Point(x=$x, y=$y)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}

