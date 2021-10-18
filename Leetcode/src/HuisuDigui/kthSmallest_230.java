package HuisuDigui;

import day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 */
public class kthSmallest_230 {

    List<Integer> ret = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return ret.get(k - 1);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        ret.add(root.val);
        dfs(root.right);
    }
}
