package String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
 * 补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是 最短补全词 。
 * 在匹配 licensePlate 中的字母时：
 * 忽略 licensePlate 中的 数字和空格 。
 * 不区分大小写。
 * 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。
 * 可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
 * 请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。
 * 当有多个单词都符合最短补全词的匹配条件时取 words 中 最靠前的 那个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 解释：最短补全词应该包括 "s"、"p"、"s"（忽略大小写） 以及 "t"。
 * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 * "steps" 包含 "t"、"p" 和两个 "s"。
 * "stripe" 缺一个 "s"。
 * "stepple" 缺一个 "s"。
 * 因此，"steps" 是唯一一个包含所有字母的单词，也是本例的答案。
 */
public class shortestCompletingWord_748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        // 先对数组排序，以长度排序
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int[] hash = new int[26];
        int count = 0;
        // 统计片段字符中的字母出现
        for (char ch : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLowerCase(ch)) {
                hash[ch - 'a']++;
                count++;
            }
        }
        //按照顺序对比
        for (String word : words) {
            // 复制hash表
            int[] temp = Arrays.copyOf(hash, hash.length);
            int countTemp = 0;
            for (char ch : word.toCharArray()) {
                if (temp[ch - 'a'] > 0) {
                    temp[ch - 'a']--;
                    countTemp++;
                }
            }
            if (countTemp == count) {
                return word;
            }
        }
        return null;
    }
}
