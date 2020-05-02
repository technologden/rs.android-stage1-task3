package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val numberOfPosters = array[0]
        val numberOfColors = array[1]

        if (numberOfPosters < 1 || numberOfColors < 1)
            return null

        var colorCount = 0

        for (i in 1 until numberOfColors){
            if (getCombination(numberOfColors, i) == numberOfPosters
                && (colorCount > i || colorCount == 0))
                colorCount = i
        }

        if (colorCount<1)
            return null
        return colorCount
    }

    //Binomial Coefficient
    private fun getCombination(n: Int, k: Int): Int{
        if (k == 1)
            return n
        if (n == k)
            return 1
        return getCombination(n-1, k) + getCombination(n - 1, k - 1)
    }
}