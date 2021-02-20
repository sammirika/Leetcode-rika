package array;


import java.util.Arrays;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 **/
public class findShortestSubArray_697 {

    public int findShortestSubArray(int[] nums) {
        // 利用hash特性
        int[] hash = new int[50000];
        int[] left = new int[50000];
        int[] right = new int[50000];
        Arrays.fill(left, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
            right[nums[i]] = i;
            // 找到最左边
            if (left[nums[i]] == -1) {
                left[nums[i]] = i;
            }
            max = Math.max(max, hash[nums[i]]);
        }
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (hash[nums[i]] == max) {
                res = Math.min(res, right[nums[i]] - left[nums[i]] + 1);
            }
        }
        return res;
    }
}
