package array;

/**
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 ******/
public class countBinarySubstrings_696 {

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }

    // cur pre 分别代表当前，之前的连续字符的数量
    public static int countBinarySubstrings(String s) {
        int pre = 0;
        int res = 0;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                res++;
            }
        }
        return res;
    }
}
