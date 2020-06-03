/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * **/
package day;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = null;
        A.right = new TreeNode(2);
        A.right.left = new TreeNode(3);
        List<Integer> list = inorderTraversal(A);
        for(int a:list){
            System.out.println(a);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null || !stack.empty()){
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
