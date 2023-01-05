package Sort;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。
 * <p>
 * 漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length
 * 且 low <= (nums[i] XOR nums[j]) <= high 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,2,7], low = 2, high = 6
 * 输出：6
 * 解释：所有漂亮数对 (i, j) 列出如下：
 * - (0, 1): nums[0] XOR nums[1] = 5
 * - (0, 2): nums[0] XOR nums[2] = 3
 * - (0, 3): nums[0] XOR nums[3] = 6
 * - (1, 2): nums[1] XOR nums[2] = 6
 * - (1, 3): nums[1] XOR nums[3] = 3
 * - (2, 3): nums[2] XOR nums[3] = 5
 */
public class countPairs_1803 {

    public int countPairs(int[] nums, int low, int high) {
        // 暴力
        Arrays.sort(nums);
        int ret = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] ^ nums[j]) >= low && (nums[i] ^ nums[j]) <= high) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
