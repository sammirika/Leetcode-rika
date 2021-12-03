package array;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 */
public class largestSumAfterKNegations_1005 {

    public static int largestSumAfterKNegations(int[] nums, int k) {
        // 先排序
        int ret = 0;
        Arrays.sort(nums);
        // 如果前面有负数可以直接把负数反过来
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                k--;
                nums[i] = -nums[i];
            }
            // 负数转正
            ret += nums[i];
        }
        if (k == 0) {
            return ret;
        }
        Arrays.sort(nums);
        return k % 2 == 0 ? ret : ret - nums[0] * 2;
    }

    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
    }

}
