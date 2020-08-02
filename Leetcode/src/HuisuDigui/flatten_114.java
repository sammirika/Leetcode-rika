package HuisuDigui;

import day.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 ****/
public class flatten_114 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten1(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //根据链表的结构可以看出来是一个DLR的结构
    //递归
    public static void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

    //迭代，用栈,注意的是这里是改变原树的结构
    public static void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        //定义前节点
        TreeNode pre = null;
        //迭代和重建同时发生，与链表类似
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            if (pre != null) {
                pre.left = null;
                pre.right = cur;
            }
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            //先进后出满足DLR
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            //每次改变前驱节点，以重建二叉树
            pre = cur;
        }
    }

}
