import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val x = readLine().toInt()

    val arr = IntArray(n)
    for(i in 0 until n){
        arr[i] = st.nextToken().toInt()
    }

    arr.sort()
    var start = 0
    var end = arr.size - 1
    var answer =0
    while(start<end){
        val sum = arr[start] + arr[end]
        if(sum==x) answer++

        if(sum<=x) start++
        else end--
    }
    println(answer)
}