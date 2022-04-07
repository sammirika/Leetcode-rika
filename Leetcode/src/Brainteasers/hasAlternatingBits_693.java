package Brainteasers;

/**
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 */
public class hasAlternatingBits_693 {

    public boolean hasAlternatingBits(int n) {
        String str = Integer.toString(n, 2);
        if (str.contains("00") || str.contains("11")) {
            return false;
        }
        return true;
    }

}
