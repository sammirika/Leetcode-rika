package Dp;

/**
 * 给你两个数组 nums1 和 nums2 。
 * <p>
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 * <p>
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * 输出：18
 * 解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
 * 它们的点积为 (2*3 + (-2)*(-6)) = 18 。
 ****/
public class maxDotProduct_1458 {

    // dp解决
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][n];
        // dp数组赋初值
        dp[0][0] = nums1[0] * nums2[0];
        // 第一行赋初值
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], nums1[0] * nums2[i]);
        }
        // 第一列赋初值
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
        }
        // 动态规划填表格
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 三种情况对点积进行更新
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i - 1][j - 1] + nums1[i] * nums2[j], dp[i][j]);
                dp[i][j] = Math.max(dp[i][j], nums1[i] * nums2[j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
