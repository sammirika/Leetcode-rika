package Sreach;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * 示例1：
 * <p>
 * <p>
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 * <p>
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 */
public class largestValues_515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(max);
            max = Integer.MIN_VALUE;
        }
        return ret;
    }

    public static void main(String[] args) {
        largestValues_515 kobe = new largestValues_515();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        System.out.println(kobe.largestValues(root));
    }
}
