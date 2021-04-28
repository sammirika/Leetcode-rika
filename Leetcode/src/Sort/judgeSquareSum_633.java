package Sort;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 */
public class judgeSquareSum_633 {

    public boolean judgeSquareSum(int c) {
        int left = 0;
        int rigth = (int) Math.pow(c, 0.5);
        while (left <= rigth) {
            int sum = left * left + rigth * rigth;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                rigth--;
            }
        }
        return false;
    }
}
