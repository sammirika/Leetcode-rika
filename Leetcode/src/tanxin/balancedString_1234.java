package tanxin;

/**
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * 请返回待替换子串的最小可能长度。
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * 示例 2：
 * <p>
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * 1 <= s.length <= 10^5
 * s.length 是 4 的倍数
 * s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 */
public class balancedString_1234 {

    public int balancedString(String s) {
        // 滑动窗口,本题只需要窗口外每种字符的数目小于等于平均值即可
        int len = s.length();
        int[] hash = new int[26];
        // 统计次数
        for (int i = 0; i < len; i++) {
            hash[s.charAt(i) - 'A']++;
        }
        // 平均值
        int avg = len / 4;
        int left = 0;
        int right = 0;
        int ret = len;
        while (right < len) {
            hash[s.charAt(right) - 'A']--;
            // 如果符合要求
            while (left < len && hash['Q' - 'A'] <= avg && hash['W' - 'A'] <= avg
                    && hash['E' - 'A'] <= avg && hash['R' - 'A'] <= avg) {
                ret = Math.min(ret, right - left + 1);
                // 缩小范围
                hash[s.charAt(left) - 'A']++;
                left++;
            }
            right++;
        }
        return ret;
    }
}
