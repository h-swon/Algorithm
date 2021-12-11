import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val P = st.nextToken().toInt()

    val guitar = Array(7) { Stack<Int>() }
    var answer = 0
    for (i in 1..N) {
        st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val p = st.nextToken().toInt()

        while(!guitar[n].isEmpty() && guitar[n].peek() > p){
            guitar[n].pop()
            answer++
        }
        if(guitar[n].isEmpty() || guitar[n].peek() != p){
            guitar[n].push(p)
            answer++
        }

    }
    println(answer)
}