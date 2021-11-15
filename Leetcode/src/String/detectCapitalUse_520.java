package String;

import java.util.*;

/**
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * 示例 1：
 * <p>
 * 输入：word = "USA"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：word = "FlaG"
 * 输出：false
 */
public class detectCapitalUse_520 {

    public boolean detectCapitalUse(String word) {
        boolean flagLow = false;
        boolean flagHigh = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                if (i == 0) {
                    continue;
                }
                flagHigh = true;
            }
            if (ch >= 'a' && ch <= 'z') {
                flagLow = true;
            }
        }
        if (flagHigh && flagLow) {
            return false;
        }
        return true;
    }
}
