package HuisuDigui;

import day.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，
 * 返回所有出现次数最多的子树元素和（不限顺序）。
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: root = [5,2,-3]
 * 输出: [2,-3,4]
 * 示例 2：
 * <p>
 * 输入: root = [5,2,-5]
 * 输出: [2]
 */
public class findFrequentTreeSum_508 {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (max == map.get(key)) {
                list.add(key);
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    // dfs求和
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + dfs(node.left) + dfs(node.right);
        map.putIfAbsent(sum, 0);
        map.put(sum, map.get(sum) + 1);
        return sum;
    }


}
