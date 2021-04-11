package review;

public class Solution_411 {

    /**
     * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
     * <p>
     * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 10
     * 输出：12
     * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5));
            if (dp[i] == dp[index2] * 2) {
                index2++;
            }
            if (dp[i] == dp[index3] * 3) {
                index3++;
            }
            if (dp[i] == dp[index5] * 5) {
                index5++;
            }
        }
        return dp[n - 1];
    }
}
