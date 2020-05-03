import kotlin.collections.LinkedHashMap

const val ANSI_BLUE = "\u001B[34m"
const val ANSI_RESET = "\u001B[0m"
const val ANSI_GREEN = "\u001B[32m"
const val maxSize = 10

fun main() {

    val mid = maxSize / 2

    val data = mutableMapOf<Int, Char>()

    data[mid] = 'O'

    for (i in 0..maxSize) {
        for (j in 0..maxSize) {

            data[j]?.let {
                pXorO(it)
            } ?: pX()

        }
        println()
    }
}

fun pX() = print("$ANSI_GREEN X $ANSI_RESET")
fun pO() = print("$ANSI_BLUE O $ANSI_RESET")

fun pXorO(char: Char) = if (char == 'X') pX() else pO()