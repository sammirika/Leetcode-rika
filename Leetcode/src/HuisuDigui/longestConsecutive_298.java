package HuisuDigui;

import day.TreeNode;

/**
 * 给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。
 * 该路径，可以是从某个初始结点到树中任意结点，通过「父 - 子」关系连接而产生的任意路径。
 * 这个最长连续的路径，必须从父结点到子结点，反过来是不可以的。
 * 示例 1：
 * <p>
 * 输入:
 * <p>
 * 1
 * \
 * 3
 * / \
 * 2   4
 * \
 * 5
 * <p>
 * 输出: 3
 * <p>
 * 解析: 当中，最长连续序列是 3-4-5，所以返回结果为 3
 * 示例 2：
 * <p>
 * 输入:
 * <p>
 * 2
 * \
 * 3
 * /
 * 2
 * /
 * 1
 * <p>
 * 输出: 2
 * <p>
 * 解析: 当中，最长连续序列是 2-3。注意，不是 3-2-1，所以返回 2。
 *****/
public class longestConsecutive_298 {

    //父节点要求比子节点正好小一个
    int maxLenght = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, null, 0);
        return maxLenght;
    }

    private void dfs(TreeNode root, TreeNode parent, int length) {
        if (root == null) {
            return;
        }
        if (root.val == parent.val + 1 && parent != null) {
            length++;
        } else {
            length = 1;
        }
        maxLenght = Math.max(maxLenght, length);
        dfs(root.left, root, length);
        dfs(root.right, root, length);
    }

}
