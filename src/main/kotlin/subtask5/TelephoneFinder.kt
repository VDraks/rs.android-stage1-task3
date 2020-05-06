package subtask5

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.toInt() < 0) return null

        val result = mutableListOf<String>()

        number.forEachIndexed { index, digit ->
            fun replaceChars(neighbors: List<Char>) {
                for (element in neighbors) {
                    result.add(number.replace(number[index], element))
                }
            }

            when (digit) {
                '0' -> replaceChars(listOf('8'))
                '1' -> replaceChars(listOf('2', '4'))
                '2' -> replaceChars(listOf('1', '3', '5'))
                '3' -> replaceChars(listOf('2', '6'))
                '4' -> replaceChars(listOf('1', '5', '7'))
                '5' -> replaceChars(listOf('2', '4', '6', '8'))
                '6' -> replaceChars(listOf('3', '5', '9'))
                '7' -> replaceChars(listOf('4', '8'))
                '8' -> replaceChars(listOf('5', '7', '9', '0'))
                '9' -> replaceChars(listOf('6', '8'))
            }
        }

        return result.toTypedArray()
    }
}
