package Sort;

/**
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 * 例 1：
 * <p>
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * <p>
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 * <p>
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * <p>
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 */
public class findKthNumber_668 {

    public int findKthNumber(int m, int n, int k) {
        //二分+计数
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (getCnt(mid, m, n) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int getCnt(int num, int m, int n) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            if (num / i >= n) {
                cnt += n;
            } else {
                cnt += num / i;
            }
        }
        return cnt;
    }
}
