package Dp;

/***
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
 * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。 
 * 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
 *
 * 示例 1:
 *
 * 输入: "a"
 * 输出: 1
 * 解释: 字符串 S 中只有一个"a"子字符。
 *  
 *
 * 示例 2:
 *
 * 输入: "cac"
 * 输出: 2
 * 解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
 *  
 *
 * 示例 3:
 *
 * 输入: "zab"
 * 输出: 6
 * 解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
 *
 * *****/
public class findSubstringInWraproundString_467 {

    // 以字符动态规划
    public int findSubstringInWraproundString(String p) {
        // 只需要记录每个字符的dp值是多少，记录这个字符上能满足条件的个数
        int[] dp = new int[26];
        char[] array = (" " + p).toCharArray();
        // 动态规划
        // 连续字符串个数，用count来动态规划
        int count = 1;
        for (int i=1;i<=p.length();i++){
            int temp = array[i] - 'a';
            if (isContinuum(array[i-1],array[i])){
                count++;
            }else {
                count = 1;
            }
            dp[temp] = Math.max(dp[temp],count);
        }
        int res = 0;
        for (int i=0;i<dp.length;i++){
            res += dp[i];
        }
        return res;
    }
    //判断字符串是否连续
    private boolean isContinuum(char a, char b){
        if (a=='z' && b=='a'){
            return true;
        }
        return b-a==1;
    }
}
