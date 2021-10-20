package array;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：0
 */
public class minMoves_453 {

    public int minMoves(int[] nums) {
        // 先排序
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num - nums[0];
        }
        return sum;
    }
}
