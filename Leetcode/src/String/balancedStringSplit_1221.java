package String;

public class balancedStringSplit_1221 {

    /**
     * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
     * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     * 注意：分割得到的每个字符串都必须是平衡字符串。
     * 返回可以通过分割得到的平衡字符串的 最大数量 。
     * 示例 1：
     * <p>
     * 输入：s = "RLRRLLRLRL"
     * 输出：4
     * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     * 示例 2：
     * <p>
     * 输入：s = "RLLLLRRRLR"
     * 输出：3
     * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     */
    public int balancedStringSplit(String s) {
        int len = s.length();
        int n = 0;
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'L') {
                n++;
            } else if (s.charAt(i) == 'R') {
                n--;
            }
            if (n == 0) {
                num++;
            }
        }
        return num;
    }
}
