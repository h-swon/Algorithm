import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val lectures = Array(n) { IntArray(2) }
    val pq = PriorityQueue<Int>()

    repeat(n) { i ->
        val st = StringTokenizer(readLine())
        lectures[i][0] = st.nextToken().toInt()
        lectures[i][1] = st.nextToken().toInt()
    }
    lectures.sortWith(compareBy({ it[0] }, { it[1] }))


    for (lecture in lectures) {
        if (!pq.isEmpty() && pq.peek() <= lecture[0]) {
            pq.poll()
        }
        pq.offer(lecture[1])
    }

    println(pq.size)
}