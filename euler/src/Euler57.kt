import java.math.BigInteger

/** Solved */
class Euler57 {

    val iterations = mutableListOf<Pair<BigInteger, BigInteger>>(
        Pair(BigInteger("3"), BigInteger("2")),
        Pair(BigInteger("7"), BigInteger("5")),
        Pair(BigInteger("17"), BigInteger("12")),
        Pair(BigInteger("41"), BigInteger("29"))
    )

    fun expandNextIteration() {
        val num = iterations.last().first.times(BigInteger("2")).plus(iterations[iterations.size - 2].first)
        val denom = iterations.last().first + iterations.last().second
        iterations.add(Pair(num, denom))
    }

    fun countNumeratorsWithMoreDigits() : Int {
        var count: Int = 0
        iterations.forEach { pair ->
            if (pair.first.toString().length > pair.second.toString().length) {
                count++
            }
        }
        return count
    }
}

fun main(){

    val e = Euler57()
    while (e.iterations.size < 1000) {
        e.expandNextIteration()
    }
    println(e.iterations)
    println(e.countNumeratorsWithMoreDigits())
}