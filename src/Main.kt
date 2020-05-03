const val ANSI_BLUE = "\u001B[34m"
const val ANSI_RESET = "\u001B[0m"
const val ANSI_GREEN = "\u001B[32m"
const val maxSize = 10

val rulesMap = mutableMapOf<Int, Int>() // rules to the value they hold

val prevData = mutableMapOf<Int, Int>()

fun main() {

    setupRules() // initial rules
    val mid = maxSize / 2
    val currentData = mutableMapOf<Int, Int>()

    // Only seed middle value if rule for all 0 gives a 0
    if (rulesMap[0] == 0)
        prevData[mid] = 1

    for (i in 0..maxSize) {
        for (j in 0..maxSize) {

            if (i == 0) {
                prevData[j]?.let {
                    pXorO(it)
                    currentData[j] = it
                } ?: run {
                    pO()
                    currentData[j] = 0
                }
            } else {
                val value = getValueFromPosition(j)
                currentData[j] = value
                pXorO(value)
            }
        }
        // not copying as reference is held.
        currentData.forEach {
            prevData[it.key] = it.value
        }
        println()
    }
}

fun getValueFromPosition(currentPosition: Int): Int {
    return if (currentPosition - 1 < 0 || currentPosition + 1 > maxSize) {
        0 // if edges, return empty slate
    } else {
        val a = prevData[currentPosition - 1]!!
        val b = prevData[currentPosition]!!
        val c = prevData[currentPosition + 1]!!

        val ruleValueCode = a * 100 + (b * 10) + c
        rulesMap[ruleValueCode]!! // rule value code should always equate
    }
}

fun setupRules() {
    rulesMap[111] = 0
    rulesMap[110] = 0
    rulesMap[101] = 0
    rulesMap[100] = 0
    rulesMap[11] = 0
    rulesMap[10] = 0
    rulesMap[1] = 0
    rulesMap[0] = 1
}


fun p1() = print("$ANSI_BLUE 1 $ANSI_RESET")
fun pO() = print("$ANSI_GREEN O $ANSI_RESET")

fun pXorO(int: Int) = if (int == 1) p1() else pO()
