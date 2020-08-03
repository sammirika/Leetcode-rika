package String;


/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * **/
public class addStrings_415 {


    public String addStrings(String num1, String num2) {
        //定义进位
        int carry = 0;
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuffer str = new StringBuffer();
        while (len1 >= 0 || len2 >= 0 || carry != 0) {
            if (len1>=0){
                carry += num1.charAt(len1--) - '0';
            }
            if (len2>=0){
                carry += num2.charAt(len2--) - '0';
            }
            str.append(carry % 10);
            carry = carry / 10;
        }
        return str.reverse().toString();
    }
}
