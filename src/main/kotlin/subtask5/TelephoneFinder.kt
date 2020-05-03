package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val result = mutableListOf<String>()

        for (i in number.indices){
            val list = when(number[i]){
                '0' -> listOf('8')
                '1' -> listOf('2', '4')
                '2' -> listOf('1', '3', '5')
                '3' -> listOf('2', '6')
                '4' -> listOf('1', '5', '7')
                '5' -> listOf('2', '4', '6', '8')
                '6' -> listOf('3', '5', '9')
                '7' -> listOf('4', '8')
                '8' -> listOf('5', '7', '9', '0')
                '9' -> listOf('6', '8')
                else -> return null
            }
            for (j in list){
                result.add(number.substring(0, i) + j + number.substring(i + 1, number.length))
            }

        }
        return result.toTypedArray()
    }
}
