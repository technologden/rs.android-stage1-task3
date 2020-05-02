package temp

import kotlin.math.abs

fun main() {
    val numbers = arrayOf<Int>(-2, -6, 45, 5, 32, 0, 3, 5)

    println(demo1(numbers))
}

fun demo1(numbers: Array<Int>): String? {
    if (numbers.isEmpty())
        return null
    val sb = StringBuilder()

    for (i in numbers.indices){
        if (numbers[i] == 0)
            continue
        when(i){
            0 -> {
                sb.append(numbers[i])
                    .append("x^")
                    .append(numbers.size-1)
                    .append(" ")
            }
            numbers.size-1 -> {
                if (numbers[i] > 0)
                    sb.append("+ ")
                else
                    sb.append("- ")
                sb.append(abs(numbers[i]))
            }
            else -> {
                if (numbers[i] > 0)
                    sb.append("+ ")
                else
                    sb.append("- ")
                if (abs(numbers[i])==1)
                    sb.append("x")
                else
                    sb.append(abs(numbers[i])).append("x")
                if (i != numbers.size-2)
                    sb.append("^").append(numbers.size-1 - i)
                sb.append(" ")
            }
        }
    }
    return sb.toString()
}