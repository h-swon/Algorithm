import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    val expression = StringTokenizer(readLine(), "-")
    var min = Integer.MAX_VALUE

    while (expression.hasMoreTokens()) {
        val sub = StringTokenizer(expression.nextToken(), "+")
        var minusValue = 0
        while (sub.hasMoreTokens()) {
            minusValue += sub.nextToken().toInt()
        }

        if (min == Integer.MAX_VALUE) {
            min = minusValue
        } else {
            min -= minusValue
        }
    }
    println(min)
}