package Brainteasers;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 */
public class isPerfectSquare_367 {

    // 二分
    public static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left < right) {
            int mid = (left + right) >> 1;
            int ret = num / mid;
            if (ret == mid) {
                return num % mid == 0;
            } else if (ret < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
    }
}
