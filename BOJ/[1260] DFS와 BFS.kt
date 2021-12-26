import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*
import kotlin.collections.ArrayList

lateinit var nodeList: Array<ArrayList<Int>>
lateinit var isVisited: BooleanArray
lateinit var sb: StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val v = st.nextToken().toInt()
    sb = StringBuilder()
    nodeList = Array(n + 1) { arrayListOf<Int>() }
    isVisited = BooleanArray(n + 1)

    for (i in 1..m) {
        st = StringTokenizer(readLine())
        val r = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        nodeList[r].add(c)
        nodeList[c].add(r)
    }

    for (list in nodeList) {
        list.sort()
    }

    // DFS
    dfs(v)
    sb.append("\n")

    // BFS
    Arrays.fill(isVisited, false)
    bfs(v)

    println(sb)
}

fun dfs(v: Int) {
    if (isVisited[v]) return
    isVisited[v] = true
    sb.append("$v ")
    for (nextNode in nodeList[v]) {
        dfs(nextNode)
    }
}

fun bfs(v: Int) {
    val queue = LinkedList<Int>()
    queue.offer(v)
    isVisited[v] = true

    while (!queue.isEmpty()) {
        var size = queue.size
        while (size-- > 0) {
            val v = queue.poll()
            sb.append("$v ")
            for (nextNode in nodeList[v]) {
                if (!isVisited[nextNode]) {
                    isVisited[nextNode] = true
                    queue.offer(nextNode)
                }
            }
        }
    }
}