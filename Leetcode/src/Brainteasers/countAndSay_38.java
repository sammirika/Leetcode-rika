package Brainteasers;

/***
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 */
public class countAndSay_38 {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        // 求出前一个的字符串
        String pre = countAndSay(n - 1);
        // 对pre进行描述
        int i = 0;
        StringBuilder str = new StringBuilder();
        while (i < pre.length()) {
            int j = i + 1;
            int count = 1;
            while (j < pre.length() && pre.charAt(j) == pre.charAt(i)) {
                count++;
                j++;
            }
            str.append(count).append(pre.charAt(i));
            i = j;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }
}
