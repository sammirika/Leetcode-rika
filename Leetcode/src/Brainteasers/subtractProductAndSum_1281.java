package Brainteasers;

/**
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 * <p>
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 */
public class subtractProductAndSum_1281 {

    public int subtractProductAndSum(int n) {
        String str = String.valueOf(n);
        char[] array = str.toCharArray();
        int sum = 0;
        int multSum = 1;
        for (char ch : array) {
            sum += ch - '0';
            multSum *= ch - '0';
        }
        return multSum - sum;
    }
}
