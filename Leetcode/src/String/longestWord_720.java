package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
 * 示例 2：
 * <p>
 * 输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
 */
public class longestWord_720 {

    public static String longestWord(String[] words) {
        Arrays.sort(words);
        String ret = "";
        Set<String> set = new HashSet<>();
        for (String str : words) {
            if (str.length() == 1 || set.contains(str.substring(0, str.length() - 1))) {
                ret = str.length() > ret.length() ? str : ret;
                set.add(str);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"}));
    }
}
