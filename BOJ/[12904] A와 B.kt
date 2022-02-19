fun main() = with(System.`in`.bufferedReader()) {
    val S = readLine()
    val T = StringBuilder(readLine())
    while (S.length < T.length) {
        when (T[T.length - 1]) {
            'A' -> {
                T.deleteCharAt(T.length - 1)
            }
            'B' -> {
                T.deleteCharAt(T.length - 1).reverse()
            }
        }
    }
    if (T.toString() == S)
        println(1)
    else
        println(0)
}