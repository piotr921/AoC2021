fun main(args: Array<String>) {
    println("Hello Task 19!")

    val input = args
        .map { a -> a.toCharArray() }

//    input.forEach { println(it) }
    val row1Map = input[0]
        .toList()
        .groupingBy { it }
        .eachCount()
    row1Map.forEach { println(it) }
    val unclosedChars = row1Map
        .filter { (key, occurrences) -> row1Map[closingChar(key)] != occurrences }
        .map { (key, _) -> key }
        .toList()
    unclosedChars.forEach { println(it) }
//    val removed = isClosed(input[0])
//    removed.forEach { println(it) }
}

fun isClosed(toSearch: CharArray): CharArray {

    var duringRemoval = toSearch
    for (i in duringRemoval.indices) {
        val startChar = duringRemoval[i]
        for (j in i + 1 until duringRemoval.size) {
            if (duringRemoval[j] == closingChar(startChar)) {

                break
            }
        }
    }

    return duringRemoval
}

fun removeChar(arr: CharArray, index: Int): CharArray {
    return if (index < 0 || index >= arr.size) {
        arr
    } else (arr.indices)
        .filter { i: Int -> i != index }
        .map { i: Int -> arr[i] }
        .toCharArray()
}

fun closingChar(openingChar: Char): Char {
    return when (openingChar) {
        '(' -> ')'
        '[' -> ']'
        '{' -> '}'
        '<' -> '>'
        else -> '?'
    }
}