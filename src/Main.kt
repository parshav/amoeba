const val ANSI_BLUE = "\u001B[34m"
const val ANSI_RESET = "\u001B[0m"
const val ANSI_GREEN = "\u001B[32m"
const val maxSize = 10

fun main() {
    val mid = maxSize / 2

    for (i in 0..maxSize) {
        for (j in 0..maxSize) {
            if (j == mid) printO() else printX()
        }
        println()
    }
}

fun printX() = print("$ANSI_GREEN X $ANSI_RESET")
fun printO() = print("$ANSI_BLUE O $ANSI_RESET")