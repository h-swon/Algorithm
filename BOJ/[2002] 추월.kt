fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val hm = HashMap<String, Int>()
    var answer = 0
    for (i in 1..n) {
        hm[readLine()] = i
    }
    for (i in 1..n) {
        val carNumber = readLine()
        val inComing = hm[carNumber]
        if (i < inComing!!) { // 나온 순서가 들어간 순서보다 빠른 경우
            answer++
        } else {
            kotlin.run {
                hm.values.forEach { value ->
                    if (value < inComing) {
                        answer++
                        return@run
                    }
                }
            }
        }
        hm.remove(carNumber)
    }
    println(answer)
}