import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine());

    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val queue = LinkedList<Int>()
    val sb = StringBuilder()
    sb.append("<")

    for (i in 1..n) {
        queue.offer(i)
    }

    while(queue.size != 1) {
        for (i in 1 until k) {
            queue.offer(queue.poll())
        }
        sb.append("${queue.poll()}, ")
    }
    sb.append("${queue.poll()}>")
    println(sb)
}