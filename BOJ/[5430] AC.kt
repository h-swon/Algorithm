import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    val T = readLine().toInt()
    repeat(T) {
        val p = readLine().toCharArray()
        val n = readLine().toInt()
        val x = readLine().replace("[", "").replace("]", "").split(",")

        var firstIdx = 0
        var endIdx = x.size - 1
        var isReverse = false
        var isError = false
        var cnt = 0
        val sb = StringBuilder()
        for (command in p) {
            when (command) {
                'R' -> {
                    isReverse = !isReverse
                }
                'D' -> {
                    if (++cnt > n) {
                        isError = true
                        break
                    }

                    if (isReverse) {
                        endIdx--
                    } else {
                        firstIdx++
                    }
                }
            }

        }
        if (isError)
            println("error")
        else {
            sb.append("[")
            if (n - cnt > 0) {
                if (isReverse) {
                    for (i in endIdx downTo firstIdx) {
                        sb.append(x[i])
                        if (i != firstIdx)
                            sb.append(",")
                    }
                } else {
                    for (i in firstIdx..endIdx) {
                        sb.append(x[i])
                        if (i != endIdx)
                            sb.append(",")
                    }
                }
            }
            sb.append("]")
            println(sb.toString())
        }
    }
}