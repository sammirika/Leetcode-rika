package array;

/***
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * *****/
public class numberOfSubarrays_1248 {

    // 差分
    public int numberOfSubarrays(int[] nums, int k) {
        int[] preOdds = new int[nums.length+1];
        preOdds[0] = 1;
        int res = 0;
        // 差分
        // sum 统计前面的数组
        int sum = 0;
        for (int num:nums){
            sum += num&1;
            // 统计前面的数组个数
            preOdds[sum]++;
            // 如果出现了前缀中已经包含了k个奇数
            if (sum >= k){
                res += preOdds[sum - k];
            }
        }
        return res;
    }
}
