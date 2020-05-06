package subtask1

import kotlin.math.abs

class PolynomialConverter {

    private fun sign(i: Int, index: Int, numbers: Array<Int>): String {
        return if (i >= 0) {
            if (index == 0) "" else " + "
        } else {
            " - "
        }
    }

    private fun koef(i: Int, index: Int, numbers: Array<Int>): String {
        return if (abs(i) == 1 && index != numbers.size - 1) ""
            else abs(i).toString()
    }

    private fun getX(i: Int, index: Int, numbers: Array<Int>): String {
        return when (index) {
            numbers.size - 1 -> ""
            numbers.size - 2 -> "x"
            else -> "x^" + (numbers.size - 1 - index).toString()
        }
    }

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) return null

        return numbers.mapIndexed { index, i ->
            if (i == 0) {
                ""
            } else {
                val sign = sign(i, index, numbers)
                val koef = koef(i, index, numbers)
                val x = getX(i, index, numbers)
                sign + koef + x
            }
        }.joinToString("")
    }
}
