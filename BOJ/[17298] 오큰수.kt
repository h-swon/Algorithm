import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val sb = StringBuilder()
    val stack = Stack<Int>()

    val sequence = IntArray(n) { 0 }
    for (i in 0 until n) {
        sequence[i] = st.nextToken().toInt()
    }

    for ((i, value) in sequence.withIndex()) {
        while (!stack.isEmpty() && sequence[stack.peek()] < value) {
            sequence[stack.pop()] = value
        }
        stack.push(i)
    }
    while (!stack.isEmpty())
        sequence[stack.pop()] = -1

    sequence.forEach {
        sb.append("$it ")
    }

    println(sb)
}