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
 * 输入：word = "ijddacfafh"
 * 输出： [1,1,2,5,1]
 * ******/
public class kexin619_01 {
    public static void main(String[] args) {
        List<Integer> list = subStringLen("Kick");
        for (int a:list){
            System.out.println(a);
        }
    }

    public static List<Integer> subStringLen(String s){
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            int j = s.length()-1;
            while (j>i){
                if (s.charAt(i)==s.charAt(j)){
                    j = getMaxSub(i,j,s);
                    list.add(j-i+1);
                    break;
                }
                j--;
            }
            if (j==i){
                list.add(1);
            }else {
                i = j;
            }
        }
        return list;
    }
    private static int getMaxSub(int m,int n,String s){
        if (m+1==n || n==s.length()-1){
            return n;
        }
        int maxcount = 0;
        for (int i=m+1;i<n;i++){
            int j = s.length()-1;
            while (j>i){
                if (s.charAt(i) == s.charAt(j)){
                    maxcount = Math.max(maxcount,j);
                }
                j--;
            }
        }
        return maxcount;
    }
}
