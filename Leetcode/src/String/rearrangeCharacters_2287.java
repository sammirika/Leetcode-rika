package String;

/**
 * 给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，
 * 得到若干新的字符串。
 * 从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ilovecodingonleetcode", target = "code"
 * 输出：2
 * 解释：
 * 对于 "code" 的第 1 个副本，选取下标为 4 、5 、6 和 7 的字符。
 * 对于 "code" 的第 2 个副本，选取下标为 17 、18 、19 和 20 的字符。
 * 形成的字符串分别是 "ecod" 和 "code" ，都可以重排为 "code" 。
 * 可以形成最多 2 个 "code" 的副本，所以返回 2 。
 */
public class rearrangeCharacters_2287 {

    public int rearrangeCharacters(String s, String target) {
        // hash
        int[] hash = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            hash[s.charAt(i) - 'a']++;
        }
        int[] hashTaget = new int[26];
        for (char ch : target.toCharArray()) {
            hashTaget[ch - 'a']++;
        }
        int ret = Integer.MAX_VALUE;
        for (char ch : target.toCharArray()) {
            ret = Math.min(ret, hash[ch - 'a'] / hashTaget[ch - 'a']);
        }
        return ret;
    }
}
