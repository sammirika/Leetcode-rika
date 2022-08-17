package HuisuDigui;

import day.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 */
public class deepestLeavesSum_1302 {

    Map<Integer, Integer> map = new HashMap<>();
    int maxDepth = 0;

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    maxDepth = Math.max(depth, maxDepth);
                    if (!map.containsKey(maxDepth)) {
                        map.put(maxDepth, node.val);
                    } else {
                        map.put(maxDepth, map.get(maxDepth) + node.val);
                    }
                    continue;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return map.get(maxDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        deepestLeavesSum_1302 kobe = new deepestLeavesSum_1302();
        System.out.println(kobe.deepestLeavesSum(root));
    }
}
