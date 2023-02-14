package Windows;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 示例 2：
 * <p>
 * 输入：hours = [6,6,6]
 * 输出：0
 */
public class longestWPI_1124 {

    public int longestWPI(int[] hours) {
        int len = hours.length;
        // 前缀和
        int sum[] = new int[len + 1];
        int ret = 0;
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + (hours[i] > 8 ? 1 : -1);
        }
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= i; j++) {
                if (sum[i] > sum[j]) {
                    ret = Math.max(ret, i - j);
                }
            }
        }
        return ret;
    }
}
