package HuisuDigui;

import day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 ****/
public class pathSum_113 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(10);
        pathSum_113 kobe = new pathSum_113();
        List<List<Integer>> lists = kobe.pathSum(root, 9);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    private List<List<Integer>> lists = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return lists;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            //这一步记得要new一个list
            lists.add(new ArrayList<>(path));
        }

        //回溯
        dfs(root.left, sum);
        dfs(root.right, sum);

        //剪枝
        path.remove(path.size() - 1);

    }
}
