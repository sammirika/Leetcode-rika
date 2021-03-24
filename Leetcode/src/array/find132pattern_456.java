package array;


/**
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 *
 * **/
public class find132pattern_456 {

    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int len = nums.length;
        for (int i = 0; i < len-2; i++) {
            int max = nums[i + 1];
            int A = nums[i];
            for (int j = i + 2; j < len; j++) {
                if (max > A && nums[j] < max && nums[j] > A) {
                    return true;
                }
                max = Math.max(max, nums[j]);
            }
        }
        return false;
    }
}
