package temp

import java.util.*


fun main() {

    val arr = decompose(1234567)
    if (arr != null)
        for (i in arr)
            println(i)
}

fun decompose(n: Int): Array<Int>? {
    val nL = n.toLong()
    val decomposeList = decomposer(nL, nL * nL)
    if (decomposeList.isNullOrEmpty()) return null

    decomposeList.removeAt(decomposeList.size - 1)

    val result: MutableList<Int> = mutableListOf()


    for (i in decomposeList) {
        result.add(i.toInt())
    }
    return result.toTypedArray()
}

fun decomposer(n: Long, remain: Long): MutableList<Long>? { // basic case
    var result:  MutableList<Long>? = mutableListOf()
    if (remain == 0L) {
        if (result != null) {
            result.add(n)
        }
        return result
    }


    for (i in n - 1 downTo 1) {
        if (remain - i * i >= 0) {
            result = decomposer(i, remain - i * i)
            // only get the answer
            if (result != null) {
                result.add(n)
                return result
            }
        }
    }
    return null
}

