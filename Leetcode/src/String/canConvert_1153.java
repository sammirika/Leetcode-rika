package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * 给出两个长度相同的字符串，分别是 str1 和 str2。
 * 请你帮忙判断字符串 str1 能不能在 零次 或 多次 转化后变成字符串 str2。
 * 每一次转化时，将会一次性将 str1 中出现的 所有 相同字母变成其他 任何 小写英文字母（见示例）。
 * 只有在字符串 str1 能够通过上述方式顺利转化为字符串 str2 时才能返回 True，否则返回 False。​​
 *
 * 示例 1：
 *
 * 输入：str1 = "aabcc", str2 = "ccdee"
 * 输出：true
 * 解释：将 'c' 变成 'e'，然后把 'b' 变成 'd'，接着再把 'a' 变成 'c'。注意，转化的顺序也很重要。
 * 示例 2：
 *
 * 输入：str1 = "leetcode", str2 = "codeleet"
 * 输出：false
 * 解释：我们没有办法能够把 str1 转化为 str2。
 *
 * *******/
public class canConvert_1153 {

    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            if (map.containsKey(str1.charAt(i))) {
                // 出现一个字符存在多个映射的情况
                if (map.get(str1.charAt(i)) != str2.charAt(i)) {
                    return false;
                }
            } else {
                map.put(str1.charAt(i), str2.charAt(i));
            }
            set.add(str2.charAt(i));
        }
        // 判断是否存在极限情况，26个字符都包含，形成一个环
        return set.size() < 26;
    }
}
