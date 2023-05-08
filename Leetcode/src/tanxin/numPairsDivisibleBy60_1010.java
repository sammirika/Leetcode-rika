package tanxin;

/**
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，
 * 我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 * <p>
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 */
public class numPairsDivisibleBy60_1010 {

    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        // 记录
        int[] record = new int[60];
        for (int t : time) {
            // 对60求余
            t = t % 60;
            if (t != 0) {
                count += record[60 - t];
            } else {
                count += record[t];
            }
            record[t]++;
        }
        return count;
    }
}
