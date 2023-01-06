package array;

/**
 * 给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
 * 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 4
 * 输出：2
 * 解释：
 * 只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。
 */
public class countEven_2180 {

    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (sumNum(i) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private int sumNum(int num) {
        if (num < 10) {
            return num;
        }
        int ret = 0;
        while (num != 0) {
            ret += num % 10;
            num /= 10;
        }
        return ret;
    }
}
