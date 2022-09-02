package HuisuDigui;

import day.TreeNode;

/**
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。
 * 这条路径可以经过也可以不经过根节点。
 * <p>
 * 两个节点之间的路径长度 由它们之间的边数表示。
 * 示例 1:
 * <p>
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * 示例 2:
 * <p>
 * <p>
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 *  
 * 提示:
 * <p>
 * 树的节点数的范围是 [0, 104] 
 * -1000 <= Node.val <= 1000
 * 树的深度将不超过 1000 
 */
public class longestUnivaluePath_687 {

    // 左右字数各自找最大的长度
    private int ret;

    public int longestUnivaluePath(TreeNode root) {
        this.ret = 0;
        getMaxLen(root);
        return ret;
    }

    private int getMaxLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = getMaxLen(root.left);
        int rightMax = getMaxLen(root.right);
        int leftLen = 0;
        int rightLen = 0;
        if (root.left != null && root.left.val == root.val) {
            leftLen = leftMax + 1;
        }

        if (root.right != null && root.right.val == root.val) {
            rightLen = rightMax + 1;
        }
        ret = Math.max(ret, leftLen + rightLen);
        return Math.max(leftLen, rightLen);
    }
}
