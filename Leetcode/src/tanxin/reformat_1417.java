package tanxin;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，
 * 而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * 示例 1：
 * <p>
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * 示例 3：
 * <p>
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * 示例 4：
 * <p>
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * 示例 5：
 * <p>
 * 输入：s = "ab123"
 * 输出："1a2b3"
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 */
public class reformat_1417 {

    public static String reformat(String s) {
        // 分别统计字符和数字
        Queue<Character> queue = new LinkedList<>();
        int countNum = 0;
        Queue<Character> queueStr = new LinkedList<>();
        int countStr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                countStr++;
                queueStr.offer(s.charAt(i));
            } else {
                countNum++;
                queue.offer(s.charAt(i));
            }
        }
        if (Math.abs(countNum - countStr) > 1) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        while (!queueStr.isEmpty() && !queue.isEmpty()) {
            if (countNum > countStr) {
                str.append(queue.poll());
                countNum--;
                str.append(queueStr.poll());
                countStr--;
            } else {
                str.append(queueStr.poll());
                countStr--;
                str.append(queue.poll());
                countNum--;
            }
        }
        if (!queue.isEmpty()) {
            str.append(queue.poll());
        }
        if (!queueStr.isEmpty()) {
            str.append(queueStr.poll());
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));
    }
}
