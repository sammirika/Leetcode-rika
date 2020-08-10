package HuisuDigui;

import day.TreeNode;
/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * ****/
public class lowestCommonAncestor_236 {

    //递归逻辑，当一个节点，如果他的左子树包含一个右子树也包含一个，那么判定生效，
    // 同时如果它自己就是其中一个且子树中包含一个也满足
    private TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }

    //递归的结构取决于这个节点的左子树中包含p,右子树中包含q,这种的情况，
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root==null){
            return false;
        }
        boolean leftSon = dfs(root.left,p,q);
        boolean rightSon = dfs(root.right,p,q);
        if ((leftSon && rightSon) || ((root.val == p.val || root.val == q.val) && (leftSon || rightSon))){
            res = root;
        }
        return leftSon || rightSon || (root.val == p.val || root.val == q.val);
    }
}
