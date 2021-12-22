package String;

/**
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，
 * 如果不存在则返回 -1。
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 * 示例 1：
 * <p>
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * 示例 2：
 * <p>
 * 输入：a = "a", b = "aa"
 * 输出：2
 */
public class repeatedStringMatch_686 {

    public int repeatedStringMatch(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        boolean[] hash = new boolean[26];
        for (char ch : a.toCharArray()) {
            hash[ch - 'a'] = true;
        }
        for (char ch : b.toCharArray()) {
            if (!hash[ch - 'a']) {
                return -1;
            }
        }
        int k = bLen / aLen;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < k + 3; i++) {
            str.append(a);
            if (str.toString().contains(b)) {
                return i+1;
            }
        }
        return -1;
    }
}
