package String;


/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * **/
public class findTheDifference_389 {

    public static char findTheDifference(String s, String t) {
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            hash[ch - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] < 0) {
                return (char) ('a' + i);
            }
        }
        return 'a';
    }
}
