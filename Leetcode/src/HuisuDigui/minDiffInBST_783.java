package HuisuDigui;

import day.TreeNode;

public class minDiffInBST_783 {

    /**
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     *
     * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同 
     *
     * 示例 1：
     *
     *
     * 输入：root = [4,2,6,1,3]
     * 输出：1
     */
    private int res = Integer.MAX_VALUE;
    private int pre = -1;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre == -1){
            pre = root.val;
        }else {
            res = Math.min(res,root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
