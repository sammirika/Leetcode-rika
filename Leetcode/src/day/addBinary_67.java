package day;


/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * *****/
public class addBinary_67 {

    public static void main(String[] args) {
        System.out.println(addBinary2("11","1"));
    }

    //api方式数组越界
    public static String addBinary(String a, String b) {
        int A = Integer.parseInt(a,2);
        int B = Integer.parseInt(b,2);
        return Integer.toBinaryString(A+B);
    }
    public static String addBinary2(String a, String b){
        if (a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        StringBuilder res = new StringBuilder();
        int i = 0, car = 0;
        for (; i < b.length(); i++) {
            Integer valuea = 0;
            if (a.length() - i - 1 >= 0) {
                valuea = (a.charAt(a.length() - i - 1) - '0');
            }
            Integer valueb = (b.charAt(b.length() - i - 1) - '0');
            car = car + valuea + valueb;
            res.append(Integer.valueOf(car % 2));
            car = car / 2;
        }
        if (car > 0) {
            res.append("1");
        }
        res.reverse();
        return res.toString();
    }

}
