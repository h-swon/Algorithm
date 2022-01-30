import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n)
    val answer = IntArray(2)
    val st = StringTokenizer(readLine())

    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }
    arr.sort()
    var start = 0
    var end = n - 1
    var diff = Int.MAX_VALUE

    while (start < end) {
        val sum = arr[start] + arr[end]
        if (abs(sum) < diff) {
            diff = abs(sum)
            answer[0] = arr[start]
            answer[1] = arr[end]
        }
        if (sum < 0) start++
        else end--
    }
    println("${answer[0]} ${answer[1]}")
}