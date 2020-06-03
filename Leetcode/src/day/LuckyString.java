/***
 * 给定字符串 s ，请你按照字典序输出所有能在登录时显示出 LUCKY 的字符串。输出的字符串不能重复。
 *
 * 示例 1：
 *
 * 输入：s = "aabcd"
 * 输出：["a", "aa", "aab", "aabc", "ab", "abc", "b", "bc", "bcd", "c", "cd", "d"]
 * 解释：4 不是斐波那契数。所以不能有类似"abcd"的字符串。
 * ***/
package day;

import java.util.*;

public class LuckyString {

    public static void main(String[] args) {
        String[] kobe = LuckyString.lucky("aabcd");
        for (String S:kobe){
            System.out.println(S);
        }
    }


    public static String[] lucky(String s){
        HashSet<Integer> Num = new HashSet<>();
        int[] fb = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if (i==0||i==1){
                fb[i] = i;
            }else{
                fb[i] = fb[i-2] + fb[i-1];
            }
            Num.add(fb[i]);
        }
        Set<String> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            for (int j=i;i<s.length();j++){
                set.add(s.substring(i,j));
            }
        }
        //此时list中元素按照字典序排列
        ArrayList<String> list = new ArrayList<>();
        list.addAll(set);
        Collections.sort(list);
        Set<Character> temp = new HashSet<>();
        List<String> aim = new ArrayList<>();
        for(String str:list){
            char[] array = str.toCharArray();
            for(char ch:array){
                temp.add(ch);
            }
            if (Num.contains(temp.size())){
                aim.add(str);
            }
            temp.clear();
        }
        return aim.toArray(new String[aim.size()]);
    }
}
