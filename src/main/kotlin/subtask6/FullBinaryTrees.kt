package subtask6

class FullBinaryTrees {
    fun stringForNodeCount(count: Int): String {

        val roots = getNodes(count)

        val result =  roots.map { root ->
            val nodeStr = "[0,$root]"
            nodeStr.dropLastWhile { c -> c != '0' } + ']'
        }
        return "$result"
    }

    class Node(private val left: Node?, private val right: Node?) {
        private val value: Int = 0

        override fun toString(): String {
            return if (left == null && right == null) "${left},${right},"
            else "${left?.value},${right?.value},$left$right"
        }
    }

    private fun getNodes(count: Int): List<Node> {
        if (count % 2 == 0) return listOf()
        if (count == 1) return listOf(Node(null, null))

        val list = mutableListOf<Node>()

        for (i in 1 until count step 2) {
            for (left in getNodes(i)) {
                for (right in getNodes(count - i - 1)) {
                    list.add(Node(left, right))
                }
            }
        }
        return list
    }
}
