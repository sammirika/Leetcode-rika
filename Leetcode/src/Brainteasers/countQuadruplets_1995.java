package Brainteasers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,6]
 * 输出：1
 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,3,6,4,5]
 * 输出：0
 * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
 */
public class countQuadruplets_1995 {

    public static int countQuadruplets(int[] nums) {
        int len = nums.length;
        // 暴力
        int ret = 0;
        int[] hash = new int[301];
        for (int i = 2; i < len; i++) {
            ret += hash[nums[i]];
            for (int j = i - 1; j > 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    hash[nums[i] + nums[j] + nums[k]]++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num = new int[]{9, 6, 8, 23, 39, 23};
        System.out.println(countQuadruplets(num));
    }
}
