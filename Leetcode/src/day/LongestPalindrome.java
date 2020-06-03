/**
 *
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 *
 *
 * 直接处理为反转字符然后再跟反转字符求最长连续公共子序列的问题 babbad ->dabbab
 * ***/
package day;

public class LongestPalindrome {

    public static void main(String[] args) {
    }

    public  String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }
        int len = s.length();
        int maxlen = 0;
        int maxend = 0;
        //求得反转字符串
        String reverse = new StringBuffer(s).reverse().toString();
        int[][] array = new int[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        array[i][j] = 1;
                    } else {
                        //这里只求对角线就是连续的字串
                        array[i][j] = array[i - 1][j - 1] + 1;
                    }
                    if (array[i][j] > maxlen) {
                        int beforeRev = len - 1 - j;
                        if (beforeRev + array[i][j] - 1 == i) { //判断下标是否对应
                            maxlen = array[i][j];
                            maxend = i;
                        }
                    }
                }
            }
        }
        return s.substring(maxend - maxlen + 1, maxend + 1);
    }
}
