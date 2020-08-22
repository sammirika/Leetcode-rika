package String;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 * <p>
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 ****/

// 滑动窗口
public class lengthOfLongestSubstringTwoDistinct_159 {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 3) {
            return s.length();
        }
        int[] hash = new int[256];
        int left = 0;
        int right = 0;
        int count = 0;
        int max = 0;
        // 利用窗口维护count
        while (right < s.length()) {
            // 滑动右边更新hash表
            if (hash[s.charAt(right++)]++ == 0) {
                count++;
            }
            // 窗口中包含了2个以上字母则需要滑动左边
            if (count > 2) {
                if (--hash[s.charAt(left++)] == 0) {
                    count--;
                }
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

}
