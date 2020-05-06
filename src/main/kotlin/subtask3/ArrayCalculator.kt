package subtask3

import kotlin.math.abs

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val intItems = itemsFromArray.filterIsInstance<Int>()
        if (intItems.isEmpty()) return 0
        if (intItems.size <= numberOfItems) return intItems.fold(1, { acc, i -> acc * i })

        val absList = intItems.sortedWith(compareByDescending { abs(it) })

        val firstN = absList.take(numberOfItems).toMutableList()
        val negativeCount = firstN.filter { it < 0 }.size
        if (negativeCount % 2 == 0) return firstN.fold(1, { acc, i -> acc * i })

        firstN.remove(firstN.last { it < 0 })
        firstN.add(absList.takeLast(absList.size - numberOfItems).first { i -> i > 0 })

        return firstN.fold(1, { acc, i -> acc * i })
    }
}
