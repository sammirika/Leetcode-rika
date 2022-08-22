package HuisuDigui;

import day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 * <p>
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 *  ["2","",""]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4]
 * 输出：
 * [["","","","1","","",""],
 *  ["","2","","","","3",""],
 *  ["","","4","","","",""]]
 */
public class printTree_655 {


    private List<List<String>> ret;
    private int m;
    private int n;
    private int height;

    public List<List<String>> printTree(TreeNode root) {
        ret = new ArrayList<>();
        m = getHeight(root);
        height = m - 1;
        n = (int) Math.pow(2, height + 1) - 1;
        // 初始化
        for (int row = 0; row < m; row++) {
            List<String> list = new ArrayList<>();
            for (int col = 0; col < n; col++) {
                list.add("");
            }
            ret.add(list);
        }
        placeNode(0, (n - 1) / 2, root);
        return ret;
    }

    private void placeNode(int row, int col, TreeNode node) {
        if (node == null) return;
        ret.get(row).set(col, String.valueOf(node.val));
        placeNode(row + 1, col - (int) Math.pow(2, height - row - 1), node.left);
        placeNode(row + 1, col + (int) Math.pow(2, height - row - 1), node.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
