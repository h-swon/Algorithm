import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val schedule = Array(n) { IntArray(2) }
    var answer = 0
    var endTime = 0

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        schedule[i][0] = start
        schedule[i][1] = end
    }

    schedule.sortWith(compareBy({ it[1] }, { it[0] }))
    for (time in schedule) {
        if (time[0] >= endTime) {
            answer++
            endTime = time[1]
        }
    }
    println(answer)
}