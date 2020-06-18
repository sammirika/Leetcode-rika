package Sreach;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 *
 * *******/
public class recoverFromPreorder_1028 {
    public static void main(String[] args) {
        TreeNode root = recoverFromPreorder("1-2--3--4-5--60--7");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if (temp!=null){
                    System.out.print(temp.val + " ");
                }
                if (temp.left!=null){
                    queue.add(temp.left);
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }

    }

    public static TreeNode recoverFromPreorder(String S) {
        //用一个变量保存深度，同时用一个栈来保存构建节点，栈的容量也代表深度
        int preindex = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (preindex<S.length()){
            //每次循环的深度默认都是0；
            int level = 0;
            //遇到"-"继续加索引
            while(S.charAt(preindex)=='-'){
                preindex++;
                //深度加一
                level++;
            }
            //常数变量
            int val = 0;
            //如果是常数
            while (preindex<S.length() && Character.isDigit(S.charAt(preindex))){
                //数字可能很大
                val = val*10 + (S.charAt(preindex) - '0');
                preindex++;
            }
            TreeNode node = new TreeNode(val);
            //如果深度和栈的容量相等，则可以进行左右子树赋值操作
            if (level==stack.size()){
                //因为如果节点只有一个子节点，那么保证该子节点为左子节点。
                if(!stack.isEmpty()){
                    stack.peek().left = node;
                }
            }else{
                //找到父节点
                while (stack.size()!=level){
                    stack.pop();
                }
                stack.peek().right = node;
            }
            //每次都要加入节点
            stack.push(node);
        }
        while (stack.size()>1){
            stack.pop();
        }
        return stack.peek();
    }
}
