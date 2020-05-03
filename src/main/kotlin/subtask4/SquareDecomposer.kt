package subtask4

import temp.decomposer
import java.util.ArrayList

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        val numberL = number.toLong()
        val decomposeList = decomposer(numberL, numberL * numberL)
        if (decomposeList.isNullOrEmpty()) return null

        decomposeList.removeAt(decomposeList.size - 1)

        val result = mutableListOf<Int>()
        for (i in decomposeList)
            result.add(i.toInt())
        return result.toTypedArray()
    }

    private fun decomposer(n: Long, remain: Long): MutableList<Long>? { // basic case
        var result:  MutableList<Long>? = mutableListOf()
        if (remain == 0L) {
            result?.add(n)
            return result
        }

        for (i in n - 1 downTo 1) {
            if (remain - i * i >= 0) {
                result = decomposer(i, remain - i * i)

                if (result != null) {
                    result.add(n)
                    return result
                }
            }
        }

        return null
    }
}
