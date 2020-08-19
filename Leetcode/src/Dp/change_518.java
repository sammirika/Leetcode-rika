package Dp;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * ****/
public class change_518 {

    // 动态规划解法
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i=0;i<len;i++){
            for (int j=1;j<=amount;j++){
                if (j - coins[i] >= 0){
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
