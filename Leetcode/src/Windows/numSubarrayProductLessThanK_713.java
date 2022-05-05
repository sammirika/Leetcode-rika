package Windows;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * 示例 1：
 * <p>
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 */
public class numSubarrayProductLessThanK_713 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int ans = 0;
        int mut = nums[0];
        while (r < nums.length && l < nums.length) {
            if (mut < k) {
                if (++r < nums.length) {
                    mut *= nums[r];
                }
                ans += (r - l);
            } else {
                mut /= nums[l++];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
