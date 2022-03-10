package Sreach;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 */
public class preorder_589 {
    List<Integer> ret = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null){
            return ret;
        }
        ret.add(root.val);
        dfs(root);
        return ret;
    }

    private void dfs(Node root){
        if (root == null){
            return;
        }
        for (Node node:root.children){
            ret.add(node.val);
            dfs(node);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder1(Node root) {
        //非递归版
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(root == null)
            return res;
        stack.push(root);
        while(!stack.isEmpty())
        {
            Node node = stack.pop();
            res.add (node.val);
            for(int i =  node.children.size()-1;i>= 0;i--)
            {
                stack.add(node.children.get(i));
            }
        }
        return res;
    }
}
