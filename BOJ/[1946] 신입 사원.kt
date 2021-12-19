import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val array = Array(n) { Score(0, 0) }
        var answer = 1
        repeat(n) {
            val st = StringTokenizer(readLine())
            array[it].document = st.nextToken().toInt()
            array[it].interview = st.nextToken().toInt()
        }

        array.sortBy { it.document }
        var compareScore = array[0].interview
        for(i in 1 until n){
            if(array[i].interview < compareScore){
                compareScore = array[i].interview
                answer++
            }
        }
        println(answer)
    }
}

data class Score(var document: Int, var interview: Int)