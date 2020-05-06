package subtask2

class Combinator {

    private fun factorial(n: Int) = when {
        n < 0 -> throw IllegalArgumentException("negative numbers not allowed")
        else -> {
            var ans = 1L
            for (i in 2..n) ans *= i
            ans
        }
    }

    private fun binomial(n: Int, k: Int) = when {
        n < 0 || k < 0 -> throw IllegalArgumentException("negative numbers not allowed")
        n == k -> 1L
        else -> {
            var ans = 1L
            for (i in n - k + 1..n) ans *= i
            ans / factorial(k)
        }
    }

    fun checkChooseFromArray(array: Array<Int>): Int? {
        for (i: Int in 1..array[1]) {
            val binomial = binomial(array[1], i).toInt()
            if (binomial == array[0]) return i
        }
        return null
    }
}
