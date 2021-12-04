import java.util.*
import kotlin.collections.LinkedHashSet

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val k = st.nextToken().toInt()
    val l = st.nextToken().toInt()
    val successSet = LinkedHashSet<String>()
    for (i in 1..l) {
        val studentCode = readLine()
        if (successSet.contains(studentCode)) {
            successSet.remove(studentCode)
        }
        successSet.add(studentCode)
    }

    for ((cnt, studentCode) in successSet.withIndex()) {
        if (cnt + 1 > k) {
            break
        }
        println(studentCode)
    }
}