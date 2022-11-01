package String;

/**
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 * 示例 1：
 *
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 *
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 *
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 */
public class arrayStringsAreEqual_1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder A = new StringBuilder();
        StringBuilder B = new StringBuilder();
        for (String str: word1){
            A.append(str);
        }
        for (String str:word2){
            B.append(str);
        }
        return A.toString().equals(B.toString());
    }
}
