package HuisuDigui;

import day.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 */
public class findBottomLeftValue_513 {

    public static int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
        }
        return root.val;
    }

    int ret = 0;
    // 定义深度
    int depth = Integer.MIN_VALUE;

    public int findBottomLeftValueDfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        // 深搜
        dfs(root, 0);
        return ret;
    }

    private void dfs(TreeNode root, int level) {
        if (root != null) {
            if (root.left == null && root.right == null && depth < level) {
                ret = root.val;
                depth = level;
            }
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        System.out.println(findBottomLeftValue(node));
    }
}
