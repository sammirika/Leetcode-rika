package Brainteasers;

/**
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * <p>
 * 请你找出并返回只出现一次的那个数。
 * <p>
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 */
public class singleNonDuplicate_540 {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        for (int i = 0; i < n; i++) {
            if (i == 0 && nums[i] != nums[i + 1]) {
                return nums[i];
            }
            if (i == n - 1 && nums[i] != nums[i - 1]) {
                return nums[i];
            }
            if (i != 0 && i != n - 1) {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
