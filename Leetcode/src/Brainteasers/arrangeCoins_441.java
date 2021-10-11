package Brainteasers;

/**
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 */
public class arrangeCoins_441 {

    public static int arrangeCoins(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n -= count;
        }
        return n == 0 ? count : count - 1;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
}
