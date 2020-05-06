package subtask4

class SquareDecomposer {

    private fun decompose(prev: Long, rest: Long): MutableList<Long>? {
        if (rest == 0L) return mutableListOf()

        for (next in prev downTo 0) {
            val diff = rest - next * next
            if (diff < 0) continue
            val result = decompose(next - 1, diff) ?: continue
            result.add(next)
            return result
        }

        return null
    }

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 0) return null

        val numberL = number.toLong()
        val result = decompose(numberL - 1, numberL * numberL) ?: return null

        return result.map { l -> l.toInt() }.toTypedArray()
    }
}
