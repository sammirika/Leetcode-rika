package Sreach;


import day.TreeNode;
import java.util.*;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * 示例 1:
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 *
 * ****/
public class bfs_662 {
    public static void main(String[] args) {
        bfs_662 kobe = new bfs_662();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(7);
        System.out.println(kobe.widthOfBinaryTree(root));
    }


    //想到使用bfs层序遍历,这里我们把每个点都标注一下从根节点开始标注，根节点为1，左边的节点为2*i 右边的节点为2*i+1，这里考虑的是，二叉树的子节点的下标是有规律的
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null || (root.left==null && root.right==null)){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //记录宽度的
        int maxlen = 0;
        //存放节点下标的
        LinkedList<Integer> list = new LinkedList<>();
        //存放根节点下标为1
        list.add(1);
        while (!queue.isEmpty()){
            //每一层的size
            int size =queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                //取出下标
                int temp = list.removeFirst();
                System.out.println(temp);
                if (node.left!=null){
                    queue.add(node.left);
                    list.add(2*temp);
                }
                if (node.right!=null){
                    queue.add(node.right);
                    list.add(2*temp+1);
                }
            }
            //如果当前层只有一个点，那就没有算的必要了
            if(list.size() >= 2) {
                maxlen = Math.max(maxlen, list.getLast() - list.getFirst() + 1);
            }
        }
        return maxlen;
    }

}
