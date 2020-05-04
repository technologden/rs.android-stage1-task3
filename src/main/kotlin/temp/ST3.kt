package temp

import kotlin.math.abs

fun main() {
    val number = 3
    val array1 = arrayOf(-100, -2, 50, -7, 1, 3, 10)
    val array2 = arrayOf("1", 2.5, 1)
    val array3 = arrayOf(" ", "q")

    println(maxProductOf(number, arrayOf(-1000000, 20, 5, 1, 7, -5)))



}

fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
    val sortList = itemsFromArray
        .filterIsInstance<Int>()
        .sortedBy { abs(it) }.reversed()

    if (sortList.isEmpty()){return 0}


    var result = 1

    if (sortList.size<= numberOfItems){
        for (i in sortList)
            result *=i
        return result
    }
    for (i in 0 until numberOfItems)
        result *= sortList[i]

    val positiveList = sortList.filter { i -> i > 0  }
    var resultPositive = 1

    for (i in 0 until numberOfItems)
        resultPositive *= positiveList[i]

    if (resultPositive>=result)
        return resultPositive
    else
        return result
}
