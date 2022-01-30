import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val s = st.nextToken().toInt()
    st = StringTokenizer(readLine())

    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }
    var start = 0
    var end = 0
    var sum = 0
    var min = Int.MAX_VALUE

    while (true) {
        if (sum >= s) {
            min = Math.min(min, end - start)
            sum -= arr[start++]
        } else if (end == n) break
        else sum += arr[end++]
    }
    if (min == Int.MAX_VALUE) {
        println(0)
    } else
        println(min)

}