package Brainteasers;

/**
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：1
 */
public class countNumbersWithUniqueDigits_357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int ret = 10;
        for (int i = 2, last = 9; i <= n; i++) {
            int cur = last * (10 - i + 1);
            ret += cur;
            last = cur;
        }
        return ret;
    }
}
