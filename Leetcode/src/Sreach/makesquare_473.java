package Sreach;

import java.util.Arrays;

/**
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用所有的火柴棍 拼成一个正方形。
 * 你不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须使用一次 。
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。 
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 * <p>
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 */
public class makesquare_473 {

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        return allocate(nums, nums.length - 1, new int[4], sum / 4);
    }

    private boolean allocate(int[] nums, int pos, int[] sums, int avg) {
        if (pos == -1) {
            return sums[0] == avg && sums[1] == avg && sums[2] == avg;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[pos] > avg) {
                continue;
            }
            sums[i] += nums[pos];
            if (allocate(nums, pos - 1, sums, avg)) {
                return true;
            }
            sums[i] -= nums[pos];
        }
        return false;
    }
}
