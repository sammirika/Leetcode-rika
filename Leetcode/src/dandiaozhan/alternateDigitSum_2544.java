package dandiaozhan;

/**
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * 返回所有数字及其对应符号的和。
 * 示例 1：
 * <p>
 * 输入：n = 521
 * 输出：4
 * 解释：(+5) + (-2) + (+1) = 4
 * 示例 2：
 * <p>
 * 输入：n = 111
 * 输出：1
 * 解释：(+1) + (-1) + (+1) = 1
 * 示例 3：
 * <p>
 * 输入：n = 886996
 * 输出：0
 * 解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 */
public class alternateDigitSum_2544 {

    public static int alternateDigitSum(int n) {
        char[] ch = String.valueOf(n).toCharArray();
        int len = ch.length;
        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                ret += (ch[i] - '0');
            } else {
                ret -= (ch[i] - '0');
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(alternateDigitSum(886996));
    }
}
