package HuisuDigui;

import day.TreeNode;


/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 ***/
public class minCameraCover_968 {


    // 全局变量记录监控器
    private int sum = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (dfs(root) == 2) {
            sum++;
        }
        return sum;
    }

    // 记录三种状态 0代表监控，1代表可达不监控，2代表不可达
    private int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 2 || right == 2) {
            sum++;
            return 0;
        } else if (left == 0 || right == 0) {
            return 1;
        } else {
            return 2;
        }
    }
}
