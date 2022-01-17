package Dp;

/**
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 * <p>
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
 */
public class countVowelPermutation_1220 {

    public int countVowelPermutation(int n) {
        long mod = 1000000007;
        long[] dp = new long[5];
        long[] Ndp = new long[5];
        // 动态规划
        for (int i = 0; i < 5; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            // a前面可以是'e','i','u'以此类推
            Ndp[0] = (dp[1] + dp[2] + dp[4]) % mod;
            Ndp[1] = (dp[0] + dp[2]) % mod;
            Ndp[2] = (dp[1] + dp[3]) % mod;
            Ndp[3] = (dp[2]) % mod;
            Ndp[4] = (dp[2] + dp[3]) % mod;
            System.arraycopy(Ndp, 0, dp, 0, 5);
        }
        long ret = 0;
        for (int i = 0; i < 5; i++) {
            ret = (ret + dp[i]) % mod;
        }
        return (int) ret;
    }
}
