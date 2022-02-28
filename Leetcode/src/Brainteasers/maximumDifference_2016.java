package Brainteasers;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，
 * 请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
 * 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
 * 示例 1：
 * <p>
 * 输入：nums = [7,1,5,4]
 * 输出：4
 * 解释：
 * 最大差值出现在 i = 1 且 j = 2 时，nums[j] - nums[i] = 5 - 1 = 4 。
 * 注意，尽管 i = 1 且 j = 0 时 ，nums[j] - nums[i] = 7 - 1 = 6 > 4 ，
 * 但 i > j 不满足题面要求，所以 6 不是有效的答案。
 */
public class maximumDifference_2016 {

    public int maximumDifference(int[] nums) {
        int ret = -1;
        int len = nums.length;
        for (int l = 0, r = 1; r < len; r++) {
            if (nums[r] <= nums[l]) {
                l = r;
            } else {
                ret = Math.max(ret, nums[r] - nums[l]);
            }
        }
        return ret;
    }
}
