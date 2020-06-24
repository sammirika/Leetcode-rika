package kexin;

import java.util.ArrayList;
import java.util.List;

/**
 * 现给定一个仅由字母组成的字符串word,现需要对其按现有顺序截成尽可能多的子串，并保证每两个字串之间无相同的字符(大小写敏感)，最后请依次返回每一个子串长度的序列。
 *
 * 子串：字符串中任意个连续的字符组成的字符串子序列称为该串的子串。
 *
 * 示例1：
 * 输入：word = "Kick"
 * 输出：[1,1,1,1]
 *
 * 示例2：
 * 输入：word = "leetcode"
 * 输出：[1,7]
 *
 *示例3：
 * 输入：word = "ijddacfahhf"
 * 输出： [1,1,2,5,1]
 * ******/
public class kexin619_01 {
    public static void main(String[] args) {
        List<Integer> list = subStringLen("qiejxqfnqceocmy");
        for (int a:list){
            System.out.println(a);
        }
    }

    public static List<Integer> subStringLen(String S){
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;

    }
}
