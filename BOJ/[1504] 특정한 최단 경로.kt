import java.util.*

val graph = arrayListOf<ArrayList<Edge>>()
const val INF = 800 * 1_000 * 3 + 1

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    repeat(n) {
        graph.add(arrayListOf())
    }

    repeat(e) {
        val edge = readLine().split(" ")
        val start = edge[0].toInt() - 1
        val end = edge[1].toInt() - 1
        val dist = edge[2].toInt()

        graph[start].add(Edge(end, dist))
        graph[end].add(Edge(start, dist))
    }

    st = StringTokenizer(readLine())
    val a = st.nextToken().toInt() - 1
    val b = st.nextToken().toInt() - 1

    val sDist = IntArray(n)
    val aDist = IntArray(n)
    val bDist = IntArray(n)

    dijkstra(0, sDist)
    dijkstra(a, aDist)
    dijkstra(b, bDist)

    val ans1 = sDist[a] + aDist[b] + bDist[n - 1]
    val ans2 = sDist[b] + bDist[a] + aDist[n - 1]
    val answer = if (ans1 >= INF && ans2 >= INF) -1 else Math.min(ans1, ans2)
    println(answer)
}

fun dijkstra(start: Int, dist: IntArray): IntArray {
    Arrays.fill(dist, INF)
    val pq = PriorityQueue<Edge>()
    dist[start] = 0
    pq.offer(Edge(start, 0))

    while (!pq.isEmpty()) {
        val cur = pq.poll()

        if (dist[cur.vertex] < cur.dist) continue

        for (next in graph[cur.vertex]) {
            val newDist = dist[cur.vertex] + next.dist
            if (newDist < dist[next.vertex]) {
                dist[next.vertex] = newDist
                pq.offer(Edge(next.vertex, newDist))
            }
        }
    }
    return dist
}


class Edge(val vertex: Int, val dist: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return dist - other.dist
    }
}