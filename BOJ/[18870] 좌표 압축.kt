import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())

    val sb = StringBuilder()
    val arr = Array(n) { 0 }
    val hm = HashMap<Int, Int>()

    repeat(n){
        arr[it] =st.nextToken().toInt()
    }

    val cloneArr = arr.clone()
    cloneArr.sort()

    var cnt = 0
    for (num in cloneArr) {
        if (!hm.containsKey(num)) {
            hm[num] = cnt++
        }
    }

    for (num in arr) {
        sb.append(hm[num]).append(" ")
    }
    println(sb)
}