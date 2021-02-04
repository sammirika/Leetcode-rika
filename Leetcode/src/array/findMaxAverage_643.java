package array;


/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 **/
public class findMaxAverage_643 {

    public static double findMaxAverage(int[] nums, int k) {
        // 求出前缀和
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        double res = -100000;
        int left = 0;
        int right = k;
        while (right < sum.length) {
            res = Math.max(res, (double) (sum[right] - sum[left]) / k);
            left++;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
