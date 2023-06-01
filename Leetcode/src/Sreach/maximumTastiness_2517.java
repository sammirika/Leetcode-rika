package Sreach;

import java.util.Arrays;

/**
 * 给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
 * 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
 * 返回礼盒的 最大 甜蜜度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：price = [13,5,1,8,21,2], k = 3
 * 输出：8
 * 解释：选出价格分别为 [13,5,21] 的三类糖果。
 * 礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
 * 可以证明能够取得的最大甜蜜度就是 8 。
 * 示例 2：
 * <p>
 * 输入：price = [1,3,1], k = 2
 * 输出：2
 * 解释：选出价格分别为 [1,3] 的两类糖果。
 * 礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
 * 可以证明能够取得的最大甜蜜度就是 2 。
 * 示例 3：
 * <p>
 * 输入：price = [7,7,7,7], k = 2
 * 输出：0
 * 解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= price.length <= 105
 * 1 <= price[i] <= 109
 * 2 <= k <= price.length
 */
public class maximumTastiness_2517 {

    public int maximumTastiness(int[] price, int k) {
        // 先排序
        Arrays.sort(price);
        // 找到最小值
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < price.length; i++) {
            min = Math.min(min, price[i] - price[i - 1]);
        }
        int l = min;
        int r = price[price.length - 1] - price[0];
        // 二分查找
        while (l <= r) {
            int mid = (l + r) >> 1;
            // 统计可以拿的个数，也就是差值大于等于mid的个数,最小的一定拿
            int cnt = 1;
            int cur = price[0];
            for (int i = 1; i < price.length; i++) {
                if (price[i] - cur >= mid) {
                    cnt++;
                    cur = price[i];
                }
            }
            if (cnt >= k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
