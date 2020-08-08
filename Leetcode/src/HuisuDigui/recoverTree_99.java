package HuisuDigui;

import day.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 二叉搜索树中的两个节点被错误地交换。

 请在不改变其结构的情况下，恢复这棵树。

 示例 1:

 输入: [1,3,null,null,2]

   1
  /
 3
  \
  2

 输出: [3,1,null,null,2]

   3
  /
 1
  \
  2
 * ******/
public class recoverTree_99 {

    private TreeNode x = null;
    private TreeNode y = null;
    private TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        //如果x和y都不为空，说明二叉搜索树出现错误的节点，将其交换
        if(x!=null && y!=null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    //中序遍历二叉树，并比较上一个节点(pre)和当前节点的值，如果pre的值大于当前节点值，则记录下这两个节点
    private void dfs(TreeNode node) {
        if(node==null) {
            return;
        }
        dfs(node.left);
        if(pre==null) {
            pre = node;
        }
        else {
            if(pre.val>node.val) {
                y = node;
                if(x==null) {
                    x = pre;
                }
            }
            pre = node;
        }
        dfs(node.right);
    }

    //迭代
    public void recoverTree1(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }

        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

}
