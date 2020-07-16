package String;

import java.util.Arrays;

/**
 * 给你两个字符串 s1 和 s2 ，它们长度相等，请你检查是否存在一个 s1  的排列可以打破 s2 的一个排列，或者是否存在一个 s2 的排列可以打破 s1 的一个排列。
 *
 * 字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]（字典序意义下的顺序）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s1 = "abc", s2 = "xya"
 * 输出：true
 * 解释："ayx" 是 s2="xya" 的一个排列，"abc" 是字符串 s1="abc" 的一个排列，且 "ayx" 可以打破 "abc" 。
 *
 * ****/
public class checkIfCanBreak_1433 {

    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("abc","xya"));
    }


    //先排序就很简单
    public static boolean checkIfCanBreak(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] nums1 = s1.toCharArray();
        char[] nums2 = s2.toCharArray();

        //相对有序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (nums1[i] >= nums2[i]) {
                index1++;
            }
            if (nums1[i] <= nums2[i]) {
                index2++;
            }
        }
        return index1 == s1.length() || index2 == s1.length();
    }
}
