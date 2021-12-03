import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")

    val mutableList = mutableListOf<String>()
    File("/Users/psekula/Workspace/AoC2021/src/main/resources/3_input.txt")
        .forEachLine { mutableList.add(it) }

    var horizontalPosition = 0
    var depth = 0
    for (index in mutableList.indices) {
        val command = mutableList[index]
//        val moveValue = command[command.length - 1].toInt()
        val moveValue = command.filter { it.isDigit() }.toInt()
        println("Line: $command; extracted number: $moveValue")
        when {
            command.contains("forward") -> horizontalPosition += moveValue
            command.contains("down") -> depth += moveValue
            command.contains("up") -> depth -= moveValue
        }
    }

    println("horizontalPosition=  $horizontalPosition")
    println("depth=  $depth")

    val result = horizontalPosition * depth
    println("Answer is: $result")
}