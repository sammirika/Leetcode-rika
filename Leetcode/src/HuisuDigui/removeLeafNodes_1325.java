package HuisuDigui;

import day.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。
 * 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。
 * 也就是说，你需要重复此过程直到不能继续删除。
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,2,null,2,4], target = 2
 * 输出：[1,null,3,null,4]
 * 解释：
 * 上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
 * 有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
 * <p>
 * <p>
 * 输入：root = [1,3,3,3,2], target = 3
 * 输出：[1,3,null,null,2]
 ***/
public class removeLeafNodes_1325 {

    // 只要找到了叶子节点，直接删除
    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        // 只删除叶子节点
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        TreeNode node = removeLeafNodes(root, 2);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode A = queue.poll();
                System.out.println(A.val);
                if (A.left != null) {
                    queue.add(A.left);
                }
                if (A.right != null) {
                    queue.add(A.right);
                }
            }
        }
    }

}
