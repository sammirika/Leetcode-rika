package SystemDesign;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，
 * 或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder ans = new StringBuilder();
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            ans.append("#");
            if (node != null){
                ans.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) {
            return null;
        }
        // 以#分割的数组
        String[] array = data.split("#", -1);
        TreeNode root = new TreeNode(Integer.parseInt(array[1]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 3; i < array.length; i += 2) {
            TreeNode node = queue.poll();
            if (array[i - 1].length() > 0) {
                node.left = new TreeNode(Integer.parseInt(array[i - 1]));
                queue.offer(node.left);
            }
            if (array[i].length() > 0) {
                node.right = new TreeNode(Integer.parseInt(array[i]));
                queue.offer(node.right);
            }
        }
        return root;
    }
}

