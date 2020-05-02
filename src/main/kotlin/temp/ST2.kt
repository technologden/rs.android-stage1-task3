package temp

fun main() {
    val array = arrayOf(4, 4)

    print(choose(array))
}

fun choose(array: Array<Int>): Int?{
    val numberOfPosters = array[0]
    val numberOfColors = array[1]

    if (numberOfPosters < 1 || numberOfColors < 1)
        return null

    var colorCount = 0

    for (i in 1 until numberOfColors){
        if (combination(numberOfColors, i) == numberOfPosters
            && (colorCount > i || colorCount == 0))
            colorCount = i
    }

    if (colorCount<1)
        return null
    return colorCount
}

//Binomial Coefficient
fun combination(n: Int, k: Int): Int{
    if (k == 1)
        return n
    if (n == k)
        return 1
    return combination(n-1, k) + combination(n - 1, k - 1)
}