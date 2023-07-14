package HuisuDigui;

import day.TreeNode;

/**
 * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。
 * (移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
 * 返回使每个结点上只有一枚硬币所需的移动次数。 
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,0,0]
 * 输出：2
 * 解释：从树的根结点开始，我们将一枚硬币移到它的左子结点上，一枚硬币移到它的右子结点上。
 */
public class distributeCoins_979 {

    // 移动次数
    private int ret = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ret;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            root.val += dfs(root.left);
        }
        if (root.right != null) {
            root.val += dfs(root.right);
        }
        ret += Math.abs(root.val - 1);
        return root.val - 1;
    }
}
