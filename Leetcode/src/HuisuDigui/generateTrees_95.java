package HuisuDigui;

import day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 示例：
 * <p>
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *******/
public class generateTrees_95 {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> list = new ArrayList<>();
        if (left < right) {
            //需要add(null)
            list.add(null);
            return list;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> nodeL = dfs(left, i - 1);
            List<TreeNode> nodeR = dfs(i + 1, right);
            for (TreeNode leftNode : nodeL) {
                for (TreeNode rightNode : nodeR) {
                    //每次以i为根结点
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
