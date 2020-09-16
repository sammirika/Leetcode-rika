package HuisuDigui;

import day.TreeNode;

import java.util.*;

public class getMinimumDifference_530 {

    public int getMinimumDifference(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        Collections.sort(res);
        int min = Integer.MAX_VALUE;
        for (int i=1;i<res.size();i++){
            min = Math.min(min,res.get(i) - res.get(i-1));
        }
        return min;
    }
}
