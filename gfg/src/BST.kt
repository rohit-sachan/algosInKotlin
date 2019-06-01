
data class TreeNode(var left: TreeNode? = null, val value : Int, var right: TreeNode? = null)

fun main() {
    val root: TreeNode = getBST()

    val nodes = mutableListOf<Int>()
    visitInOrder(root, nodes){
        it.size >= 2
    }
    println(nodes.last())

    val nodes2 = mutableListOf<Int>()
    visitInOrderReverse(root, nodes2){
        it.size >= 2
    }
    println(nodes2)
}


fun visitInOrder(root: TreeNode, nodes: MutableList<Int>,
                 predicate: (MutableList<Int>) -> Boolean){
    root.left?.let{ visitInOrder(it, nodes, predicate) }
    if (predicate.invoke(nodes)) return
    nodes.add(root.value)
    root.right?.let { visitInOrder(it,nodes, predicate) }

}

fun visitInOrderReverse(root: TreeNode, nodes: MutableList<Int>,
                        predicate: (MutableList<Int>) -> Boolean){
    root.right?.let { visitInOrderReverse(it,nodes, predicate) }
    if (predicate.invoke(nodes)) return
    nodes.add(root.value)
    root.left?.let{ visitInOrderReverse(it, nodes, predicate) }
}

fun getBST(): TreeNode {
    val root = TreeNode(value = 9)
    root.left = TreeNode(value = 3)
    root.left!!.right = TreeNode(TreeNode(value =5), 6, TreeNode(value =7))
    root.right = TreeNode(value = 17)
    root.right!!.left = TreeNode(value = 15)
    return root
}
