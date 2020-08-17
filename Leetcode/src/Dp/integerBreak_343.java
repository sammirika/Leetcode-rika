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
        integerBreak_343 kobe = new integerBreak_343();
        System.out.println(kobe.integerBreak1(10));
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

    //记忆化搜索解法
    private int[] memo;

    public int integerBreak1(int n) {
        this.memo = new int[n + 1];
        return dfs(n);
    }

    //递归
    private int dfs(int n) {
        //递归出口
        if (n == 2) {
            return 1;
        }
        // 剪枝
        if (memo[n] != 0) {
            return memo[n];
        }

        int res = -1;
        for (int i = 2; i <= n - 1; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * dfs(n - i)));
        }
        //保存记忆
        memo[n] = res;
        return res;
    }
}
