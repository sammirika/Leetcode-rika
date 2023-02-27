package tanxin;

import java.util.Map;

/**
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * <p>
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 示例 2：
 * <p>
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 */
public class movesToMakeZigzag_1144 {

    public int movesToMakeZigzag(int[] nums) {
        //偶数或者奇数
        return Math.min(help(nums, 0), help(nums, 1));
    }

    private int help(int[] nums, int pos) {
        // pos决定是奇数还是偶数锯齿
        int len = nums.length;
        int ret = 0;
        for (int i = pos; i < len; i += 2) {
            int temp = 0;
            // 前
            if (i - 1 >= 0) {
                temp = Math.max(temp, nums[i] - nums[i-1] + 1);
            }
            // 后
            if (i + 1 < len) {
                temp = Math.max(temp, nums[i] - nums[i + 1] + 1);
            }
            ret += temp;
        }
        return ret;
    }
}
