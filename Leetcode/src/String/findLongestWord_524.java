package String;

import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 * 示例 1：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 */
public class findLongestWord_524 {

    public String findLongestWord(String s, List<String> dictionary) {
        String ret = "";
        for (String t : dictionary) {
            int i = 0;
            int j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }
            // 可以得到字符串T
            if (i == t.length()) {
                if (t.length() > ret.length() || (t.length() == ret.length() && t.compareTo(ret) < 0)) {
                    ret = t;
                }
            }
        }
        return ret;
    }
}
