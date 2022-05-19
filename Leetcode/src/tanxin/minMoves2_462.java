package tanxin;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,2,9]
 * 输出：16
 */
public class minMoves2_462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        int res = 0;
        while (l < r) {
            res += nums[r--] - nums[l++];
        }
        return res;
    }
}
