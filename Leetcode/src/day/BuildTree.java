/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * *******/

package day;

import java.util.Stack;

public class BuildTree {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        //先放根节点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inordeindex = 0;
        for (int i=1;i<preorder.length;i++){
            int preorderval = preorder[i];
            TreeNode node = stack.peek();
            if(inorder[inordeindex]!=node.val){
                node.left = new TreeNode(preorderval);
                stack.push(node.left);
            }else{
                while (!stack.empty() && stack.peek().val == inorder[inordeindex]){
                    node = stack.pop();
                    inordeindex++;
                }
                node.right = new TreeNode(preorderval);
                stack.push(root.right);
            }
        }
        return root;
    }
}
