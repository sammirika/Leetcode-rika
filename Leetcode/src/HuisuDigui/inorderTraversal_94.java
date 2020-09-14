package HuisuDigui;

import day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 ****/
public class inorderTraversal_94 {

    List<Integer> res = new ArrayList<>();

    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return res;
    }

    public static void main(String[] args) {
        inorderTraversal_94 kobe = new inorderTraversal_94();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(kobe.inorderTraversal(root));
    }
}
