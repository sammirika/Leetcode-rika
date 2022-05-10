package Hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * <p>
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：[1]
 */
public class findDuplicates_442 {

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            hash[num]++;
            if (hash[num] == 2) {
                list.add(num);
            }
        }
        return list;
    }
}
