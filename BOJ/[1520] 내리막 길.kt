import java.util.*

var m: Int = 0
var n: Int = 0
lateinit var map: Array<IntArray>
lateinit var dp: Array<IntArray>
val dy = arrayOf(-1, 1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    m = st.nextToken().toInt()
    n = st.nextToken().toInt()
    map = Array(m) { IntArray(n) }
    dp = Array(m) { IntArray(n) }

    for (i in 0 until m) {
        st = StringTokenizer(readLine())
        for (j in 0 until n) {
            map[i][j] = st.nextToken().toInt()
            dp[i][j] = -1
        }
    }
    println(dfs(0, 0))
}


fun dfs(y: Int, x: Int): Int {

    if (y == m - 1 && x == n - 1) {
        return 1
    }

    if (dp[y][x] == -1) {
        dp[y][x] = 0
        for (i in 0 until 4) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue
            if (map[ny][nx] < map[y][x]) {
                dp[y][x] += dfs(ny, nx)
            }
        }
    }

    return dp[y][x]
}


