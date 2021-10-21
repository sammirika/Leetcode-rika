package array;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。 
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 */
public class plusOne_66 {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] temp = new int[len + 1];
        if (digits[len - 1] < 9) {
            digits[len - 1]++;
            return digits;
        }
        int count = 0;
        int index = len - 1;
        while (index >= 0 && digits[index] == 9) {
            digits[index--] = 0;
            temp[index + 1] = 0;
        }
        if (index >= 0) {
            digits[index] += 1;
            return digits;
        } else {
            temp[index + 1] += 1;
            return temp;
        }
    }
}
