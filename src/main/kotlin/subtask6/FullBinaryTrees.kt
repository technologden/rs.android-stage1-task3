package subtask6

class FullBinaryTrees {

    // TODO: Complete the following function
    fun stringForNodeCount(count: Int): String {
        val tree = makeTree(count)
        val result = mutableListOf<MutableList<Int?>>()
        for(n in tree){
            val list = getTreeAsList(n)
            while (list[list.size - 1] == null){
                list.removeAt(list.size - 1)
            }
            result.add(list)
        }
        return result.toString()
    }

    private fun getTreeAsList(n: TreeNode): MutableList<Int?>{
        val result = mutableListOf<Int?>()

        result.add(0)

        var children = mutableListOf<TreeNode?>(
            n.left, n.right
        )

        var countLevel = 0

        while(children.isNotEmpty()){
            val newChildren = mutableListOf<TreeNode?>()
            for(i in children){
                if(i == null){
                    if(countLevel != n.level)
                        result.add(null)
                } else{
                    result.add(0)
                    newChildren.add(i.left)
                    newChildren.add(i.right)
                }
            }
            children = mutableListOf()
            children.addAll(newChildren)
            countLevel++
        }
        return result
    }

    private fun makeTree(n: Int): MutableList<TreeNode>{
        if(n == 1) return mutableListOf(TreeNode(0))
        val result = mutableListOf<TreeNode>()
        for(i in 1 until n step 2){
            val left = makeTree(i)
            val right = makeTree(n - 1 - i)
            for(i in left){
                for(j in right){
                    val root = TreeNode(0)
                    root.left = i
                    root.right = j
                    root.level = maxOf(i.level, j.level) + 1
                    result.add(root)
                }
            }
        }
        return result
    }
}

class TreeNode(
    var level: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null )
