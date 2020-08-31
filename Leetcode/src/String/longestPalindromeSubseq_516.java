package String;

/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * 示例 1:
 * 输入:
 * <p>
 * "bbbab"
 * 输出:
 * <p>
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入:
 * <p>
 * "cbbd"
 * 输出:
 * <p>
 * 2
 ***/
public class longestPalindromeSubseq_516 {

    // 动态规划填表格，对角线右上方的DP,求的是非连续的
    public static int longestPalindromeSubseq(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        // dp数组赋初值
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
