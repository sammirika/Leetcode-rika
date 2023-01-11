package Brainteasers;

/**
 * 给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
 * 如果对于 每个 0 <= i < n 的下标 i ，
 * 都满足数位 i 在 num 中出现了 num[i]次，那么请你返回 true ，否则返回 false 。 
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "1210"
 * 输出：true
 * 解释：
 * num[0] = '1' 。数字 0 在 num 中出现了一次。
 * num[1] = '2' 。数字 1 在 num 中出现了两次。
 * num[2] = '1' 。数字 2 在 num 中出现了一次。
 * num[3] = '0' 。数字 3 在 num 中出现了零次。
 * "1210" 满足题目要求条件，所以返回 true 。
 */
public class digitCount_2283 {

    public static boolean digitCount(String num) {
        int[] hash = new int[11];
        // 先统计每位的数字出现次数
        for (int i = 0; i < num.length(); i++) {
            hash[num.charAt(i) - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) - '0' != hash[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
    }
}
