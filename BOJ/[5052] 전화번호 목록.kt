fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val arr = Array(n) { readLine() }.apply { sort() }

        var answer = true
        for (i in 1 until n) {
            if (arr[i].startsWith(arr[i - 1])) {
                answer = false
                break
            }
        }
        if (answer)
            println("YES")
        else
            println("NO")
    }
}