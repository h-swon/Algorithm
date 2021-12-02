import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val hs = HashSet<String>()
    val list = mutableListOf<String>()

    for (i in 1..n) {
        hs.add(readLine())
    }

    for (i in 1..m) {
        val name = readLine()
        if (hs.contains(name)) {
            list.add(name)
        }
    }

    list.sortBy { it }
    println(list.size)
    list.forEach {
        println(it)
    }
}