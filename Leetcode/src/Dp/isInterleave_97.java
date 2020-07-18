package Dp;

/**
 *
 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。

 示例 1:

 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 输出: true
 示例 2:

 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 输出: false
 * ****/

// 动态规划问题，使用矩阵来标注状态转移，在矩阵中可以画出目标字符串转移的路径
public class isInterleave_97 {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        if (s3.length() != m + n){
            return false;
        }

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++){
            if (s1.charAt(i-1) == s3.charAt(i-1)){
                dp[i][0] = true;
            }else {
                //不相等直接退出
                break;
            }
        }
        for (int j = 1; j <= n; j++){
            if (s2.charAt(j-1) == s3.charAt(j-1)){
                dp[0][j] = true;
            }else {
                //不相等直接退出
                break;
            }
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j] = ((dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
                        || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)));
            }
        }
        return dp[m][n];
    }
}
