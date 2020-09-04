package HuisuDigui;

import day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * ****/
public class binaryTreePaths_257 {

    // 递归
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String str) {
        if (root != null) {
            str += String.valueOf(root.val);
            if (root.left == null && root.right == null) {
                res.add(str);
            } else {
                str += "->";
                dfs(root.left, str);
                dfs(root.right, str);
            }
        }
    }
}
