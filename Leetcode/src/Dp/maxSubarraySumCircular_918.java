package Dp;

/**
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * 环形数组 意味着数组的末端将会与开头相连呈环状。
 * 形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * <p>
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，
 * 对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * 示例 1：
 * <p>
 * 输入：nums = [1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 示例 2：
 * <p>
 * 输入：nums = [5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * 示例 3：
 * <p>
 * 输入：nums = [3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 */
public class maxSubarraySumCircular_918 {

    public int maxSubarraySumCircular(int[] nums) {
        // 分有环，无环两种状态
        int curMax;
        int curMin;
        int max;
        int min;
        int sum;
        max = curMax = min = curMin = sum = nums[0];
        // 状态转移
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            curMax = curMax > 0 ? curMax + nums[i] : nums[i];
            max = curMax > max ? curMax : max;
            curMin = curMin < 0 ? curMin + nums[i] : nums[i];
            min = curMin < min ? curMin : min;
        }
        if (max < 0) {
            return max;
        }
        return Math.max(sum - min, max);
    }
}
