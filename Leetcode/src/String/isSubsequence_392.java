package String;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 *****/
public class isSubsequence_392 {

    public static void main(String[] args) {
        System.out.println(isSubsequence1("abc", "ahbgdc"));
    }

    //常规解法,一遍扫描
    public static boolean isSubsequence(String s, String t) {
        if (t.length() < 1 || t.length() < s.length()) {
            return false;
        }
        int index = -1;
        //扫描s,每次利用index更新t的长度
        for (char ch : s.toCharArray()) {
            index = t.indexOf(ch, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    //动态规划
    public static boolean isSubsequence1(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m > n) {
            return false;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n] == s.length();
    }

    //用两个队列的解法
    public boolean isSubsequence2(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        Queue<Character> queues = new LinkedList<>();
        Queue<Character> queuet = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queues.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            queuet.add(t.charAt(i));
        }
        while (!queuet.isEmpty()) {
            if (queues.peek() == queuet.peek()) {
                queues.poll();
            }
            queuet.poll();
        }
        return queues.isEmpty();
    }
}
