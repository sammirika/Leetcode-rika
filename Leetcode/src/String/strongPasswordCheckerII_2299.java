package String;

/**
 * 如果一个密码满足以下所有条件，我们称它是一个 强 密码：
 * 它有至少 8 个字符。
 * 至少包含 一个小写英文 字母。
 * 至少包含 一个大写英文 字母。
 * 至少包含 一个数字 。
 * 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
 * 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
 * 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：password = "IloveLe3tcode!"
 * 输出：true
 * 解释：密码满足所有的要求，所以我们返回 true 。
 * 示例 2：
 * <p>
 * 输入：password = "Me+You--IsMyDream"
 * 输出：false
 * 解释：密码不包含数字，且包含 2 个连续相同的字符。所以我们返回 false 。
 */
public class strongPasswordCheckerII_2299 {

    public static boolean strongPasswordCheckerII(String password) {
        int len = password.length();
        if (len < 8) {
            return false;
        }
        boolean A = false;
        boolean B = false;
        boolean C = false;
        boolean D = false;
        for (int i = 0; i < len; i++) {
            if (i >= 1 && password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
            if ((password.charAt(i) >= '!' && password.charAt(i) <= '-') || password.charAt(i) == '@' || password.charAt(i) == '^') {
                A = true;
            }
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                B = true;
            }
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                C = true;
            }
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                D = true;
            }
        }
        return A && B && C && D;
    }

    public static void main(String[] args) {
        System.out.println(strongPasswordCheckerII("11A!A!Aa"));
    }
}
