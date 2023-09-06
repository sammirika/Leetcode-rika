package HuisuDigui;

import day.TreeNode;

/**
 * 给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
 * 回想一下：
 * <p>
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，
 * 且 A 的深度达到此条件下可能的最大值。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
 * 示例 3：
 * <p>
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。
 */
public class lcaDeepestLeaves_1123 {
    int maxDeep = -1;
    TreeNode ret = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // 找深度
        getDeepth(root, 0);
        return ret;
    }

    private int getDeepth(TreeNode node, int deep) {
        // 出口
        if (node == null) {
            return deep;
        }
        int leftDeep = getDeepth(node.left, deep + 1);
        int rightDeep = getDeepth(node.right, deep + 1);
        int max = Math.max(leftDeep, rightDeep);

        maxDeep = Math.max(maxDeep, max);
        //
        if (leftDeep == rightDeep && max == maxDeep) {
            ret = node;
        }
        return max;
    }
}
