package HuisuDigui;

import day.TreeNode;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * 示例 1：
 *
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 *
 */
public class rangeSumBST_938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null){
            return 0;
        }
        int res = 0;
        if (root.val < low) {
            res += rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            res += rangeSumBST(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            res += root.val;
            res += rangeSumBST(root.left, low, high);
            res += rangeSumBST(root.right, low, high);
        }
        return res;
    }
}
