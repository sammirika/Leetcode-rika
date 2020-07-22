package String;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 ******/
public class minWindow_76 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0 || t.length() > s.length()) {
            return "";
        }

        //定义两个hash 表
        int[] temp = new int[128];
        int[] windows = new int[128];

        //填充temp
        for (int i = 0; i < t.length(); i++) {
            temp[t.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        String res = "";
        int minLength = s.length() + 1;
        //滑动窗口
        while (right < s.length()) {
            char ch = s.charAt(right);
            windows[ch]++;
            if (temp[ch] > 0 && temp[ch] >= windows[ch]) {
                count++;
            }
            while (count == t.length()) {
                ch = s.charAt(left);
                if (temp[ch] > 0 && temp[ch] >= windows[ch]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left++;
                windows[ch]--;
            }
            right++;
        }
        return res;
    }
}
