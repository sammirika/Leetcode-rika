package String;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。
 * 返回这一子串的长度。
 * 示例 1：
 * <p>
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 * <p>
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */
public class longestSubstring_395 {

    public int longestSubstring(String s, int k) {
        char[] array = s.toCharArray();
        int[] hash = new int[26];
        int n = s.length();
        // 递归终止条件
        if (n < k) {
            return 0;
        }
        // 统计字符出现
        for (int i = 0; i < n; i++) {
            hash[array[i] - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (hash[array[i] - 'a'] < k) {
                // 分治
                int l = longestSubstring(s.substring(0, i), k);
                int r = longestSubstring(s.substring(i+1, n), k);
                return Math.max(l, r);
            }
        }
        return n;
    }
}
