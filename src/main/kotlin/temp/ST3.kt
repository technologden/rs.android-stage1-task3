package temp

import kotlin.math.abs

fun main() {
    var num = 4
    val array1 = arrayOf(-100, -2, 50, -7, 1, 3, 10, "r")

    val list = array1.filterIsInstance<Int>().sorted()
    var start = 0
    var end = list.size - 1
    var res = 1

    while (num>=2){
        val startArr = list[start]*list[start + 1]
        val endArr = list[end]*list[end - 1]

        println("Start $startArr")
        println("End $endArr")

        if (startArr > endArr){
            res *= startArr
            start+=2
        }else{
            res *= endArr
            end -= 2
        }

        println("Start $start")
        println("End $end")

        num -= 2
    }
    if (num == 1)
        res *= maxOf(list[start], list[end])



    println(res)
}


//fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
//    val sortList = itemsFromArray
//        .filterIsInstance<Int>()
//        .sortedBy { abs(it) }.reversed()
//
//    if (sortList.isEmpty()){return 0}
//
//
//    var result = 1
//
//    if (sortList.size<= numberOfItems){
//        for (i in sortList)
//            result *=i
//        return result
//    }
//    for (i in 0 until numberOfItems)
//        result *= sortList[i]
//
//    val positiveList = sortList.filter { i -> i > 0  }
//    var resultPositive = 1
//
//    for (i in 0 until numberOfItems)
//        resultPositive *= positiveList[i]
//
//    if (resultPositive>=result)
//        return resultPositive
//    else
//        return result
//}

