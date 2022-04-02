package day;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数整除的数。
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 示例 2:
 * <p>
 * 输入：left = 47, right = 85
 * 输出：[48,55,66,77]
 */
public class selfDividingNumbers_728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSelfDividing(int num) {
        int tmp = num;
        while (tmp > 0) {
            int i = tmp % 10;
            if (i == 0 || num % i != 0) {
                return false;
            }
            tmp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        selfDividingNumbers_728 kobe = new selfDividingNumbers_728();
        System.out.println(kobe.selfDividingNumbers(1, 22));
    }
}
