package HuisuDigui;

/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：a = 2, b = 3
 * 输出：5
 */
public class getSum_371 {

    public int getSum(int a, int b) {
        return add(a, b);
    }

    public int add(int num1, int num2) {
        if (num2 == 0){
            return num1;
        }
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return add(sum,carry);
    }
}
