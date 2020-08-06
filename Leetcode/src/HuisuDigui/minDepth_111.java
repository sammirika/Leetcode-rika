package HuisuDigui;

import day.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class minDepth_111 {

    //递归
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.right != null && root.left==null){
            return 1+minDepth(root.right);
        }
        if(root.left != null && root.right==null){
            return 1+minDepth(root.left);
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }

    //迭代
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left == null && node.right==null){
                    return level;
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return level;
    }
}
