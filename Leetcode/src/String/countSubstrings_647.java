package String;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 **/
public class countSubstrings_647 {

    //中心扩散法
    private int count = 0;

    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 0; i < s.length(); i++) {
            getCount(s, i, i);
            getCount(s, i, i + 1);
        }
        return count;

    }

    private void getCount(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        countSubstrings_647 kobe = new countSubstrings_647();
        System.out.println(kobe.countSubstrings("aaa"));
    }
}
