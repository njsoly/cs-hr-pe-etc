import java.math.BigDecimal
import java.math.RoundingMode

/** Solved. */
class Euler26 (val start: Long = 1, val stop: Long = 1000, val scale: Int = 1000) {

    val bigs = mutableListOf<BigDecimal>()
    init {
        val list = mutableListOf<Long>()
        for (n in start .. stop) {
            list.add(n)
        }
        list.forEach { l ->
            bigs.add(BigDecimal("1").divide(BigDecimal(l), scale, RoundingMode.CEILING))
        }

    }

    fun solve(start: Int = 7, stop: Int = 9) : Int {
        var maxLength = Pair<Int, Int>(0,0)
        for (n in start .. stop) {
            val length = findRepeatingSection(n).length
            if (length > maxLength.second) {
                maxLength = Pair(n, length)
            }
        }

        println("max repeater is ${maxLength.second}, when n = ${maxLength.first}" )
        return maxLength.second
    }

    private fun findRepeatingSection(n: Int) : String {
        val big = bigs[n-1]
        val afterDec = big.toPlainString().substring(2)
//        println("BigDecimal of 1/$n is $afterDec")

        for (startingDigit in 0..3) {
            for (lengthToCheck in 2 .. ((scale - startingDigit) / 2)) {
                val a = afterDec.substring(startingDigit, startingDigit + lengthToCheck)
                val b = afterDec.substring(startingDigit + lengthToCheck, startingDigit + (lengthToCheck * 2))
                if (a.equals(b)) {
                    println("repeating decimal of 1/$n is $a")
                    return a
                }
            }
        }
        return ""
    }
}

fun main() {
    val euler = Euler26(scale = 2000)
//    euler.bigs.forEachIndexed{ i, it ->
//        println("${i+1}: $it")
//    }
    println(euler.solve(7, 1000))
}