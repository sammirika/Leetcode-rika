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

    //bfs求解，这里每次加入节点的纵坐标都使用一个set来保存，我们这里假定根节点起始坐标为（0，0）,需要加上判断同一坐标的判断
    public static int funtion(TreeNode root){
        //总分数用于返回
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode,int[]> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        if (root==null){
            return 0;
        }
        //将根节点加入队列
        queue.add(root);
        //存放节点与坐标的映射
        map.put(root,new int[]{0,0});
        //放进set 来计算
        set.add(0);
        sum += root.val;
        while (!queue.isEmpty()){
            int size = queue.size();
            Set<String> temp = new HashSet<>();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                int[] array = map.get(node);
                if (node.left!=null){
                    queue.add(node.left);
                    //只要重叠了就不会放进去
                    map.put(node.left,new int[]{array[0]-1,array[1]-1});
                    if (!set.contains(array[1]-1)){
                        sum += node.left.val;
                        set.add(array[1]-1);
                        temp.add(String.valueOf(array[0]-1) + String.valueOf(array[1]-1));
                    }else if(temp.contains(String.valueOf(array[0]-1) + String.valueOf(array[1]-1))){//坐标相同且在同一层，只要之前的没被挡，那么后面的自然也不会被挡住
                        sum += node.left.val;
                    }
                }
                if (node.right!=null){
                    queue.add(node.right);
                    map.put(node.right,new int[]{array[0]+1,array[1]+1});
                    if (!set.contains(array[1]+1)){
                        sum += node.right.val;
                        set.add(array[1]+1);
                        temp.add(String.valueOf(array[0]+1) + String.valueOf(array[1]+1));
                    }else if (temp.contains(String.valueOf(array[0]+1) + String.valueOf(array[1]+1))){
                        sum += node.right.val;
                    }
                }
            }
            temp.clear();
        }
        return sum;
    }
}
