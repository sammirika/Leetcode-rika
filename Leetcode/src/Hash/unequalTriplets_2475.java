package Hash;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
 * <p>
 * 0 <= i < j < k < nums.length
 * nums[i]、nums[j] 和 nums[k] 两两不同 。
 * 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
 * 返回满足上述条件三元组的数目。
 * 示例 1：
 * <p>
 * 输入：nums = [4,4,2,4,3]
 * 输出：3
 * 解释：下面列出的三元组均满足题目条件：
 * - (0, 2, 4) 因为 4 != 2 != 3
 * - (1, 2, 4) 因为 4 != 2 != 3
 * - (2, 3, 4) 因为 2 != 4 != 3
 * 共计 3 个三元组，返回 3 。
 * 注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：不存在满足条件的三元组，所以返回 0 。
 */
public class unequalTriplets_2475 {

    public int unequalTriplets(int[] nums) {
        // 先排序,[2,3,4,4,4]
        Arrays.sort(nums);
        int ret = 0;
        int start = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] != nums[i]) {
                ret += start * (i - start + 1) * (len - 1 - i);
                start = i + 1;
            }
        }
        return ret;
    }
}
