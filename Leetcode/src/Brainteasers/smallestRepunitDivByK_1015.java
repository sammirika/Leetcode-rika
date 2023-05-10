package Brainteasers;

/**
 * 给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
 * 返回 n 的长度。如果不存在这样的 n ，就返回-1。
 * 注意： n 不符合 64 位带符号整数。 
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 1
 * 输出：1
 * 解释：最小的答案是 n = 1，其长度为 1。
 * 示例 2：
 * <p>
 * 输入：k = 2
 * 输出：-1
 * 解释：不存在可被 2 整除的正整数 n 。
 * 示例 3：
 * <p>
 * 输入：k = 3
 * 输出：3
 * 解释：最小的答案是 n = 111，其长度为 3。
 */
public class smallestRepunitDivByK_1015 {

    public int smallestRepunitDivByK(int k) {
        // 穷举
        int p = 0;
        for (int i = 1; i <= k; i++) {
            p = (p * 10 + 1) % k;
            if (p == 0) {
                return i;
            }
        }
        return -1;
    }
}
