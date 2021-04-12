package review;

import day.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution_412 {

    /**
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * <p>
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [10,2]
     * 输出："210"
     * 示例 2：
     * <p>
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     */
    public String largestNumber(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        // 排序
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int n1 = 10;
                int n2 = 10;
                while (n1 <= o1) {
                    n1 *= 10;
                }
                while (n2 <= o2) {
                    n2 *= 10;
                }
                return o2 * n1 - o1 * n2 + o1 - o2;
            }
        });
        StringBuilder str = new StringBuilder();
        if (res.get(0) == 0) {
            return "0";
        }
        for (Integer temp : res) {
            str.append(temp);
        }
        return str.toString();
    }


    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
     * 返回二叉搜索树（有可能被更新）的根节点的引用。
     * 一般来说，删除节点可分为两个步骤：
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
     * <p>
     * 示例:
     * <p>
     * root = [5,3,6,2,4,null,7]
     * key = 3
     * <p>
     * 5
     * / \
     * 3   6
     * / \   \
     * 2   4   7
     * <p>
     * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
     * <p>
     * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
     * <p>
     * 5
     * / \
     * 4   6
     * /     \
     * 2       7
     * <p>
     * 另一个正确答案是 [5,2,6,null,4,null,7]。
     * <p>
     * 5
     * / \
     * 2   6
     * \   \
     * 4   7
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }else if (root.left == null) {
                return root.right;
            }else if (root.right == null) {
                return root.left;
            }else{
                // 都不为null
                TreeNode successor = minimum(root.right);
                successor.right = removeMin(root.right);
                successor.left = root.left;
                root.left = root.right = null;
                return successor;
            }
        }
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


}
