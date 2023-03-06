package String;

/**
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b'
 * 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 * 请你返回使 s 平衡 的 最少 删除次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 * <p>
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 要么是 'a' 要么是 'b'​ 。​
 */
public class minimumDeletions_1653 {

    public int minimumDeletions(String s) {
        // 看a前有多少个b
        int len = s.length();
        char[] array = s.toCharArray();
        int countB = 0;
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            if (array[i - 1] == 'b') {
                dp[i] = dp[i - 1];
                countB++;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, countB);
            }
        }
        return dp[len];
    }
}
