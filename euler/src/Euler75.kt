import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Euler75 {

    private val uniqueSolutions = mutableSetOf<Long>()

    private fun countMultiples(n: Long) : Int {
        var multipleCount = 0
        uniqueSolutions.forEach { uniqueSolution ->
            if (n % uniqueSolution == 0L) {
                multipleCount++
            }
            if (multipleCount > 1) {
                return 2
            }
        }
        return multipleCount
    }

    private fun getSolutionsOfLength(n: Long) : List<Long> {
        when (countMultiples(n)) {
            1 -> return listOf(n)
            2 -> return emptyList()
        }

        val solutions = mutableListOf<Long>()
        for (i in 2 until n/3) {
            for (j in i + 1 .. (n - i)/2) {
                val k = n - i - j
//                println("checking if $i^2 + $j^2 = $k^2")
                if (i*i + j*j == k*k) {
                    if (solutions.isEmpty()) {
                        solutions.add(n)
                        uniqueSolutions.add(n)
//                        println("uniqueSolutions: $uniqueSolutions")
                    } else {
                        return emptyList()
                    }
                }
            }
        }
        return solutions
    }

    fun solve(min: Long = 2, max: Int) : Int {
        val totalSolutions = mutableListOf<Long>()
        val reportPeriod = 1000L
        var lastReport = System.currentTimeMillis()

        for (n in min..max step(2)) {
//            println("checking for solutions of length $n")
            if (n % reportPeriod == 0L) {
                val timeSince = System.currentTimeMillis() - lastReport
                lastReport = System.currentTimeMillis()
                println("n = $n.  current solutions: ${totalSolutions.size}.  " +
                        "time: ${LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME)} " +
                        "since last report: $timeSince ms"
                )
            }
            val solns = getSolutionsOfLength(n)
            if (solns.isNotEmpty()) {
//                println("there are ${solns.size} solutions at length $n")
                totalSolutions.add(n)
            }
        }
        println("there are ${totalSolutions.size} total solutions")
        return totalSolutions.size
    }
}

fun main() {
    val startTime = System.currentTimeMillis()
    val result = Euler75().solve(12, 1500000)
    val endTime = System.currentTimeMillis()
    println("Solving took ${endTime - startTime} ms.")
    println(result)
}