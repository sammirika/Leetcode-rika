package String;


/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 *
 * ****/
public class isMatch_44 {

    public static void main(String[] args) {
        String A = "acdcb";
        String B = "a*c?";
        System.out.println(isMatch(A,B));
    }

    //动态规划，用dp[][]数组来确定位置上的匹配度
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        //两个空字符串情况为true
        dp[0][0] = true;
        //把*的情况与空字符串匹配
        for (int i=1;i<=n;i++){
            if (p.charAt(i-1)=='*'){
                dp[0][i] = true;
            }else {
                break;
            }
        }
        //动态规划，空间换时间
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else if (p.charAt(j-1)=='?' || s.charAt(i-1)==p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
