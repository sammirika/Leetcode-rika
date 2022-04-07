package Sreach;

import java.util.HashSet;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * 示例 1：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 */
public class findTarget_653 {

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode root, HashSet<Integer> set, int num) {
        if (root == null) {
            return false;
        } else if (set.contains(num - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, set, num) || dfs(root.right, set, num);
    }
}
