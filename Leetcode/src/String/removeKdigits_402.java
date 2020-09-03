package String;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 ******/
public class removeKdigits_402 {

    // 扫描K次，每一次都找到第一个比下一位大的字符
    public static String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        StringBuilder str = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int index = 0;
            // 每次都两两比较
            for (int j = 1; j < str.length() && str.charAt(j) >= str.charAt(j - 1); j++) {
                index = j;
            }
            str.deleteCharAt(index);
        }
        while (str.length() > 1 && str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("10200", 1));
    }
}
