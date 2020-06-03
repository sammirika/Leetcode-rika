/**
 * ****
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 *
 *
 * **/


package day;

public class FindTheLongestSubstring {



    public int findTheLongestSubstring(String s) {
        char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};
        int[] nums = new int[]{16, 8, 4, 2, 1};
        int[][] dp = new int[s.length() + 1][32];
        for (int i = 0; i <= s.length(); i++) for (int j = 0; j < 32; j++) dp[i][j] = -1;
        dp[0][0] = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (int j = 0; j < chars.length; j++)
                if (chars[j] == s.charAt(i)) {
                    found = true;
                    for (int k = 0; k < 32; k++) if (dp[i][k] != -1) dp[i + 1][k ^ nums[j]] = dp[i][k] + 1;
                    dp[i + 1][0] = Math.max(0, dp[i + 1][0]);
                }
            if (!found) {
                dp[i + 1][0] = dp[i][0] + 1;
                for (int k = 1; k < 32; k++) if (dp[i][k] != -1) dp[i + 1][k] = dp[i][k] + 1;
            }
            result = Math.max(result, dp[i + 1][0]);
        }
        return result;
    }
}
