package tanxin;

import java.util.Arrays;

/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 每个元素的频率在 [1,4] 范围内
 */
public class canPartitionKSubsets_698 {

    // 回溯
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int len = nums.length;
        for (int num : nums) {
            sum += num;
        }
        // 不能分成k份
        if (sum % k != 0) {
            return false;
        }

        // 排个序
        Arrays.sort(nums);
        if (nums[len - 1] > sum) {
            return false;
        }
        // 求出每份的值
        sum /= k;
        int[] arr = new int[k];
        Arrays.fill(arr, sum);
        return dfs(nums, len - 1, arr, k);
    }

    private boolean dfs(int[] nums, int index, int[] arr, int k) {
        // nums数组中所有元素都加入了桶中
        if (index < 0) {
            return true;
        }
        // 每个桶都遍历
        for (int i = 0; i < k; i++) {
            if (nums[index] == arr[i] || (index > 0 && arr[i] - nums[index] >= nums[0])) {
                arr[i] -= nums[index];
                // 递归下一个
                if (dfs(nums, index - 1, arr, k)) {
                    return true;
                }
                // 剪纸
                arr[i] += nums[index];
            }
        }
        return false;
    }
}
