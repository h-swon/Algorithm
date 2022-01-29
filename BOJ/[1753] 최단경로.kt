import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val graph = arrayListOf<ArrayList<Edge>>()
    val st = StringTokenizer(readLine())
    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()
    val k = readLine().toInt() - 1

    val costs = IntArray(v)
    Arrays.fill(costs, Integer.MAX_VALUE)
    repeat(v) {
        graph.add(arrayListOf())
    }

    repeat(e) {
        val info = readLine().split(" ")
        graph[info[0].toInt() - 1].add(Edge(info[1].toInt() - 1, info[2].toInt()))
    }

    val pq = PriorityQueue<Edge>()
    costs[k] = 0
    pq.offer(Edge(k, 0))
    while(!pq.isEmpty()){
        val cur = pq.poll()
        if(costs[cur.node] < cur.cost) continue

        for(next in graph[cur.node]){
            val cost = costs[cur.node] + next.cost
            if(cost < costs[next.node]){
                costs[next.node] = cost
                pq.offer(Edge(next.node, cost))
            }
        }
    }

    for (i in 0 until v) {
        if (costs[i] == Integer.MAX_VALUE) {
            println("INF")
        } else
            println(costs[i])
    }

}

class Edge(val node: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return cost - other.cost
    }

}
