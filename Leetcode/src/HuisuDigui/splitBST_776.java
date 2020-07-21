package HuisuDigui;

import day.TreeNode;

/**
 * 给你一棵二叉搜索树（BST）、它的根结点 root 以及目标值 V。
 * 请将该树按要求拆分为两个子树：其中一个子树结点的值都必须小于等于给定的目标值 V；另一个子树结点的值都必须大于目标值 V；树中并非一定要存在值为 V 的结点。
 * 除此之外，树中大部分结构都需要保留，也就是说原始树中父节点 P 的任意子节点 C，假如拆分后它们仍在同一个子树中，那么结点 P 应仍为 C 的子结点。
 * 你需要返回拆分后两个子树的根结点 TreeNode，顺序随意。
 * 示例：
 * <p>
 * 输入：root = [4,2,6,1,3,5,7], V = 2
 * 输出：[[2,1],[4,3,6,null,null,5,7]]
 * 解释：
 * 注意根结点 output[0] 和 output[1] 都是 TreeNode 对象，不是数组。
 * <p>
 * 给定的树 [4,2,6,1,3,5,7] 可化为如下示意图：
 * <p>
 * 4
 * /   \
 * 2      6
 * / \    / \
 * 1   3  5   7
 * <p>
 * 输出的示意图如下：
 * <p>
 * 4
 * /   \
 * 3    6  和    2
 * / \           /
 * 5   7         1
 ******/
public class splitBST_776 {


    //利用二叉搜索树特性进行分割递归
    public TreeNode[] splitBST(TreeNode root, int V) {
        //递归出口
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        if (root.val == V) {
            TreeNode[] bts = new TreeNode[2];
            bts[1] = root.right;
            root.right = null;
            bts[0] = root;
            return bts;
        } else if (root.val > V) {
            //大于的场景下则直接进行递归,left[0]不变
            TreeNode[] left = splitBST(root.left, V);
            root.left = left[1];
            left[1] = root;
            return left;
        } else {
            //小于的场景下，right[1]不变
            TreeNode[] right = splitBST(root.right, V);
            root.right = right[0];
            right[0] = root;
            return right;
        }
    }
}
