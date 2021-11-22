package HuisuDigui;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 */
public class maxDepth_559 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
//        return dfs(root, root.children);
        Queue<Node> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (Node node1 : node.children) {
                    queue.offer(node1);
                }
            }
        }
        return depth;
    }

    private int dfs(Node root, List<Node> child) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (Node node : child) {
            int max = dfs(node, node.children);
            count = Math.max(count, max);
        }
        return count + 1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
