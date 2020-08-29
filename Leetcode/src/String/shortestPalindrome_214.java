package String;
/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 示例 1:
 *
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 *
 * 输入: "abcd"
 * 输出: "dcbabcd"
 *
 *
 * ****/
public class shortestPalindrome_214 {

    // 暴力解法
    public String shortestPalindrome(String s) {
        // 如果直接匹配成功直接返回
        if (isPalindrome(s)){
            return s;
        }
        StringBuilder temp = new StringBuilder();
        for (int i=s.length();i>=0;i--){
            String str = s.substring(0,i);
            // 如果前缀是回文串，直接求出s'
            if (isPalindrome(str)){
                temp = new StringBuilder(s.substring(i)).reverse();
                break;
            }
        }
        temp.append(s);
        return temp.toString();
    }

    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while (left < right){
            if (str.charAt(left++) != str.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
