package array;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 */
public class singleNumber_260 {

    public int[] singleNumber(int[] nums) {
        int[] ret = new int[2];
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] != nums[i + 1]) {
                ret[count++] = nums[i];
            } else if (i == nums.length-1 && nums[i - 1] != nums[i]) {
                ret[count] = nums[i];
            } else {
                if (i != 0 && i != nums.length - 1 && nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    ret[count++] = nums[i];
                }
            }
        }
        return ret;
    }
}
