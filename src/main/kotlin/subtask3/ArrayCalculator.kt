package subtask3

import kotlin.math.abs

class ArrayCalculator {

    // TODO: Complete the following function
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

        val positiveList = sortList.filter { i -> i >= 0  }
        var resultPositive = 1

        for (i in 0 until numberOfItems)
            resultPositive *= positiveList[i]

        if (resultPositive>=result)
            return resultPositive
        else
            return result
    }
}
