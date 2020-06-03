/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * ***/


package day;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(ValidPalindrome.validPalindrome("abba"));
    }

    public static boolean validPalindrome(String s) {
        int len = s.length();
        int left = 0;
        int right = len-1;
        while (left<right){
            if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                boolean flagleft = true,flagright = true;
                for(int i=left+1,j=right;i<j;i++,j--){
                    if(s.charAt(i)!=s.charAt(j)){
                        flagleft = false;
                        break;
                    }
                }
                for (int i=left,j=right-1;i<j;i++,j--){
                    if(s.charAt(i)!=s.charAt(j)){
                        flagright = false;
                        break;
                    }
                }
                return flagleft||flagright;
            }
        }
        return true;
    }
}
