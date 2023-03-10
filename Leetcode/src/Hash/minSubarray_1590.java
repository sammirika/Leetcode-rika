package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。
 * 不允许 将整个数组都移除。
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 * 子数组 定义为原数组中连续的一组元素。
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,4,2], p = 6
 * 输出：1
 * 解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [6,3,5,2], p = 9
 * 输出：2
 * 解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
 */
public class minSubarray_1590 {

    public int minSubarray(int[] nums, int p) {

        long sum = Arrays.stream(nums).asLongStream().sum();
        long target = sum % p, prefix = 0, minLength = nums.length;

        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, -1);

        for (int i = 0; i < nums.length; i++) {
            long remainder = (prefix += nums[i]) % p;
            map.put(remainder, i);
            if (remainder >= target) {
                minLength = Math.min(minLength, i - map.getOrDefault(Math.abs(remainder - target), -nums.length));
            } else {
                minLength = Math.min(minLength, i - map.getOrDefault(Math.abs(remainder - target + p), -nums.length));
            }
        }

        return minLength == nums.length ? -1 : (int) minLength;

    }
}
