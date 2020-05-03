package temp

fun main() {

    val number = "8675309"

    val result = mutableListOf<String>()

    for (i in number.indices){//2 4 6 8
        var list = listOf<Char>()
        when(number[i]){
            '0' -> list = listOf('8')
            '1' -> list = listOf('2', '4')
            '2' -> list = listOf('1', '3', '5')
            '3' -> list = listOf('2', '6')
            '4' -> list = listOf('1', '5', '7')
            '5' -> list = listOf('2', '4', '6', '8')
            '6' -> list = listOf('3', '5', '9')
            '7' -> list = listOf('4', '8')
            '8' -> list = listOf('5', '7', '9', '0')
            '9' -> list = listOf('6', '8')
            //else -> return null
        }
        for (j in list){
            result.add(number.substring(0, i) + j + number.substring(i + 1, number.length))
        }

    }

    for (s in result)
        println(s)


}

