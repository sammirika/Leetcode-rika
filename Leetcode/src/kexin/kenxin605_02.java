package kexin;

import java.util.*;

/**
 * 对应image里的605_02，可以具体查看
 *树的结构体
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * ***/
public class kenxin605_02 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(funtion(root));
    }

    //bfs求解，这里每次加入节点的纵坐标都使用一个set来保存，我们这里假定根节点起始坐标为（0，0）
    public static int funtion(TreeNode root){
        //总分数用于返回
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        if (root==null){
            return 0;
        }
        //将根节点加入队列
        queue.add(root);
        //存放节点与坐标的映射
        map.put(root,0);
        //放进set 来计算
        set.add(0);
        sum += root.val;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                   queue.add(node.left);
                   //只要重叠了就不会放进去
                   if (!set.contains(map.get(node)-1)){
                       sum += node.left.val;
                       map.put(node.left,map.get(node)-1);
                       set.add((map.get(root)-1));
                   }
                }
                if (node.right!=null){
                    queue.add(node.right);
                    if (!set.contains(map.get(node)+1)){
                        sum += node.right.val;
                        map.put(node.right,map.get(node)+1);
                        set.add((map.get(node)+1));
                    }
                }
            }
        }
        return sum;
    }
}
