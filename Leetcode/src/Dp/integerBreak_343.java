package Dp;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 ******/
public class integerBreak_343 {

    public static void main(String[] args) {
        System.out.println(integerBreak(8));
    }

    //dp 常规解法 (1) ->0 (2) ->1 3 ->2 4 ->2*2 5->2*3 6->3*3 7->3*(4) 8->(5)*3
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j < i; j++) {
                temp = Math.max(temp, Math.max((i - j) * j, dp[i - j] * j));
            }
            //每一次都更新最大值
            dp[i] = temp;
        }
        return dp[n];
    }
}
