package String;
/**
 *
 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false
 * ****/
public class Day_isPalindrome_125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
    }

    //效率比较低的解法
    public static boolean isPalindrome(String s) {
        if (s.length()==0 && s==null){
            return true;
        }
        StringBuffer str = new StringBuffer();
        for (int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if (a>=65 && a<=90){
                a += 32;
            }
            if ((a>=48 && a<=57) || (a>=97 && a<=122)){
                str.append(a);
            }
        }
        String A = str.toString();
        if (A.equals(str.reverse().toString())){
            return true;
        }
        return false;
    }
    public static boolean isPalindrome2(String s){
        if (s.length()==0 && s==null){
            return true;
        }
        StringBuffer str = new StringBuffer();
        for (int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if (a>=65 && a<=90){
                a += 32;
            }
            if ((a>=48 && a<=57) || (a>=97 && a<=122)){
                str.append(a);
            }
        }
        int left = 0;
        int right = str.length()-1;
        while (left<right){
            if (str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
