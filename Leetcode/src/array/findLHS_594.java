package array;

import java.util.Arrays;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 */
public class findLHS_594 {

    public int findLHS(int[] nums) {
        // 现排序
        Arrays.sort(nums);
        int maxCount = 0;
        int begin = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end + 1] - nums[begin] > 1) {
                end++;
            }
            if (nums[end + 1] - nums[begin] == 1){
                maxCount = Math.max(maxCount,end-begin+1);
            }
        }
        return maxCount;
    }
}
