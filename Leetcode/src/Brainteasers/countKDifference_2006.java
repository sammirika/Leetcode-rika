package Brainteasers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 * |x| 的值定义为：
 * <p>
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 */
public class countKDifference_2006 {

    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int num : nums) {
            if (map.containsKey(num + k)) {
                ret += map.get(num + k);
            }
            if (map.containsKey(num - k)) {
                ret += map.get(num - k);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ret;
    }
}
