package String;
/**
 * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 *
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 *
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 *
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s1 = "xx", s2 = "yy"
 * 输出：1
 * 解释：
 * 交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。
 * 示例 2：
 *
 * 输入：s1 = "xy", s2 = "yx"
 * 输出：2
 * 解释：
 * 交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
 * 交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
 * 注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。
 *
 * *****/
public class minimumSwap_1247 {
    public static void main(String[] args) {
        System.out.println(minimumSwap("xy","yx"));
    }

    //递推s1的x 和s2的y组成xy和yx；
    public static int minimumSwap(String s1, String s2) {
        if (s1.length()!=s2.length()){
            return -1;
        }
        int xy = 0;
        int yx = 0;
        for (int i = 0;i <s1.length();i++){
            if (s1.charAt(i) == s2.charAt(i)){
                continue;
            }
            if (s1.charAt(i) == 'x'){
                xy++;
            }else {
                yx++;
            }
        }
        return (xy+yx)%2==0?(xy+1)/2+(yx+1)/2:-1;
    }
}
