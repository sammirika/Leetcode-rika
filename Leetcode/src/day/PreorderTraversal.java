/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 * ***/
package day;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode B = new TreeNode(1);
        B.left = new TreeNode(0);
        B.right = new TreeNode(2);
        B.right.left = new TreeNode(3);
        List<Integer> list = preorderTraversal(B);
        for(int a:list){
            System.out.println(a);
        }
    }


    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null || !stack.empty()){
            if (node!=null){
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                node = node.right;
            }
        }
        return list;
    }
}
