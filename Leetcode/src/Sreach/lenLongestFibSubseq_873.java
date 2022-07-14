package Sreach;

import java.util.Arrays;

/**
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如，
 *  [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 * <p>
 * 示例 1：
 * <p>
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * 示例 2：
 * <p>
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 */
public class lenLongestFibSubseq_873 {

    public int lenLongestFibSubseq(int[] arr) {
        // 动态规划
        int n = arr.length;
        // 表示以arr[i],arr[j]结尾的最长斐波那契长度
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);
        }
        int l = 0, r = 0;
        int sum = 0;
        int res = 0;
        for (int i = 1; i < n; i++) {
            l = 0;
            r = i - 1;
            while (l < r) {
                sum = arr[l] + arr[r];
                if (sum == arr[i]) {
                    dp[r][i] = Math.max(dp[r][i], dp[l][r] + 1);
                    res = Math.max(res, dp[r][i]);
                    l++;
                    r--;
                } else if (sum < arr[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
