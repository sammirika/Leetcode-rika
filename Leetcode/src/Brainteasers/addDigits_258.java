package Brainteasers;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。 
 * 示例 1:
 * <p>
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 */
public class addDigits_258 {

    public static int addDigits(int num) {
        while (num >= 10) {
            int tmp = 0;
            int len = String.valueOf(num).length();
            while (len > 0) {
                tmp += num % 10;
                num /= 10;
                len--;
            }
            num = tmp;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
