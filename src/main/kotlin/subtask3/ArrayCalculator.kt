package subtask3

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val listInt = itemsFromArray
            .filterIsInstance<Int>()

        if (listInt.isEmpty()){return 0}

        if (listInt.size<= numberOfItems){
            var result = 1
            for (i in listInt)
                result *=i
            return result
        }

        val sortListInt = listInt.sorted()
        var startIndex = 0
        var endIndex = sortListInt.size-1
        var result = 1
        var num = numberOfItems

        while (num>=2){
            val startPairProd = sortListInt[startIndex] * sortListInt[startIndex + 1]
            val endPairProd = sortListInt[endIndex] * sortListInt[endIndex - 1]

            if (startPairProd > endPairProd){
                result *= startPairProd
                startIndex += 2
            }else{
                result *= endPairProd
                endIndex -= 2
            }

            num -= 2
        }
        if (num == 1)
            result *= maxOf(sortListInt[startIndex], sortListInt[endIndex])

        return result
    }
}
