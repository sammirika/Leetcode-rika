package day;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * *****/
public class sortedArrayToBST_108 {

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        sortedArrayToBST_108 kobe = new sortedArrayToBST_108();
        TreeNode root = kobe.buildTree(0,nums.length-1,nums);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            System.out.println(" ");
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0,nums.length-1,nums);
    }

    //递归构造
    private TreeNode buildTree(int left, int right, int[] nums){
        //递归出口
        if (left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(left,mid-1,nums);
        root.right = buildTree(mid+1,right,nums);

        return root;
    }
}
