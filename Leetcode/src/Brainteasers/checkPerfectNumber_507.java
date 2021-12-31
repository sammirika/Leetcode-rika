package Brainteasers;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 */
public class checkPerfectNumber_507 {

    public static boolean checkPerfectNumber(int num) {
        int ret = 0;
        int i = 1;
        while (i <= num / 2) {
            if (num % i == 0) {
                ret += i;
            }
            i++;
        }
        return ret == num;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
}
