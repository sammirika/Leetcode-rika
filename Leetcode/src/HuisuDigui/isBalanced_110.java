package HuisuDigui;

import day.TreeNode;

import java.util.Map;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * *****/
public class isBalanced_110 {

    // 递归
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(dfs(root.left)-dfs(root.right)) >1){
            return false;
        }
        if (!isBalanced(root.left)){
            return false;
        }
        return isBalanced(root.right);
    }

    // 求节点高度
    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;

        return Math.max(left,right);
    }
}
