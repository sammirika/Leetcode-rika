package String;

import java.util.List;

/***
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * ****/
public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        LongestCommonPrefix_14 kobe = new LongestCommonPrefix_14();
        String[] num = new String[]{"dog","racecar","car"};
        System.out.println(kobe.longestCommonPrefix2(num));
    }

    //第一种暴力法
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int min = strs[0].length();
        String s = strs[0];
        for(int i=1;i<strs.length;i++){
            min = Math.min(min,funtion(s,strs[i]).length());
        }
        return s.substring(0,min);
    }

    private String funtion(String A,String B){
        int n = Math.min(A.length(),B.length());
        StringBuffer str = new StringBuffer("");
        int count = 0;
        for(int i=0;i<n;i++){
            if(A.charAt(i)==B.charAt(i) && count==i){
                count++;
                str.append(A.charAt(i));
            }
        }
        return str.toString();
    }

    //第二种滑动窗口
    public String longestCommonPrefix2(String[] strs){
        if (strs.length==0 || strs==null){
            return "";
        }
        //目标字串
        String res = strs[0];
        for (String str:strs){
            //开始滑动窗口,只要indexof不等于0那么就可以一直滑下去
            while (str.indexOf(res)!=0){
                //从最后往前一直滑
                res = res.substring(0,res.length()-1);
            }
        }
        return res;
    }

}
