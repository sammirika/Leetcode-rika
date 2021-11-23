package String;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * 示例 2：
 * <p>
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 */
public class buddyStrings_859 {

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        List<Integer> index = new ArrayList<>();
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                index.add(i);
            }
            hash[s.charAt(i) - 'a']++;
        }
        if (index.size() == 0) {
            for (int i = 0; i < 26; i++) {
                if (hash[i] >= 2) {
                    return true;
                }
            }
        }
        if (index.size() == 2) {
            // 正好等于2的情况
            int a = index.get(0);
            int b = index.get(1);
            return goal.charAt(b) == s.charAt(a) && goal.charAt(a) == s.charAt(b);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ab"));
    }
}
