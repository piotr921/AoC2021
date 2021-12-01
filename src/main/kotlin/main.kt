import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")

    val mutableList = mutableListOf<Int>()
    File("/home/piotrek/Workspace/AoC2021/src/main/resources/1_input.txt")
        .forEachLine { mutableList.add(it.toInt()) }

    var increaseCount = 0
    for (index in mutableList.indices) {
        println("Counting for: $index")
        if (index > 0) {
            if(mutableList[index] - mutableList[index - 1] > 0) {
                increaseCount += 1
            }
        }
    }

    println("No of increases=  $increaseCount")
}