package Brainteasers;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 */
public class containsNearbyDuplicate_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                } else {
                    // 更新为更近的元素
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
