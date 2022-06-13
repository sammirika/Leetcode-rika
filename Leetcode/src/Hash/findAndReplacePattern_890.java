package Hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * 返回 words 中与给定模式匹配的单词列表。
 * 你可以按任何顺序返回答案。
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 */
public class findAndReplacePattern_890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            // 互相映射，构建两个哈希表
            int[] hash1 = new int[27];
            int[] hash2 = new int[27];
            boolean flag = true;
            for (int j = 0; j < pattern.length(); j++) {
                int index = words[i].charAt(j) - 'a' + 1;
                int value = pattern.charAt(j) - 'a' + 1;
                if ((hash1[index] != 0 && hash1[index] != value) || (hash2[value] != 0 && hash2[value] != index)) {
                    flag = false;
                    break;
                }
                hash1[index] = value;
                hash2[value] = index;
            }
            if (flag) {
                ret.add(words[i]);
            }
        }
        return ret;
    }
}
