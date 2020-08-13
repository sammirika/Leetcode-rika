package String;

public class multiply_43 {

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        //竖式乘法
        int len1 = num1.length();
        int len2 = num2.length();
        String res = "0";
        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int A = num1.charAt(i) - '0';
            StringBuffer str = new StringBuffer();
            for (int j = len1 - 1; j > i; j--) {
                str.append(0);
            }
            for (int j = len2 - 1; j >= 0; j--) {
                int B = num2.charAt(j) - '0';
                int sum = A * B + carry;
                carry = sum / 10;
                str.append(sum % 10);
            }
            if (carry != 0) {
                str.append(carry);
            }
            res = addTwoString(res, str.reverse().toString());

        }
        return res;

    }


    //加法计算
    private static String addTwoString(String s1, String s2) {
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;
        int carry = 0;
        StringBuffer str = new StringBuffer();
        while (len1 >= 0 || len2 >= 0 || carry != 0) {
            if (len1 >= 0) {
                carry += s1.charAt(len1--) - '0';
            }
            if (len2 >= 0) {
                carry += s2.charAt(len2--) - '0';
            }
            str.append(carry % 10);
            carry = carry / 10;
        }
        return str.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "10"));
    }


}
