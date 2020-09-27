package HuisuDigui;

import day.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * ***/
public class lowestCommonAncestor_235 {


    // 利用二叉搜索树的特性
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        // 一次遍历出结果,只要节点满足两边各存在一个即返回
        while (res != null){
            if (p.val < res.val && q.val < res.val){
                res = res.left;
            }else if (p.val > res.val && q.val > res.val){
                res = res.right;
            }else {
                break;
            }
        }
        return res;
    }
}
