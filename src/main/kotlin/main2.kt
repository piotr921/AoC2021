import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")

    val mutableList = mutableListOf<Int>()
    File("/home/piotrek/Workspace/AoC2021/src/main/resources/2_input.txt")
        .forEachLine { mutableList.add(it.toInt()) }

    var increaseCount = 0
    for (index in mutableList.indices) {
        if (index > 2) {
            val A = mutableList[index - 3]
            val B = mutableList[index]
            println("Comparing: $B - $A")
            if(B - A > 0) {
                increaseCount += 1
            }
        }
    }

    println("No of increases=  $increaseCount")
}