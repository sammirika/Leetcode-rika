package HuisuDigui;

import day.TreeNode;

/***
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * *****/
public class convertBST_538 {

    // 记录累加的值
    private static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val = sum + root.val;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        TreeNode node = convertBST(root);
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right.val);
    }
}
