package String;

/**
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * 请你返回字符串的能量。
 * 示例 1：
 * <p>
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 示例 2：
 * <p>
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 */
public class maxPower_1446 {

    public int maxPower(String s) {
        int maxCount = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            while (right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
            }
            maxCount = Math.max(maxCount, right - left);
            left = right;
        }
        return maxCount;
    }
}
