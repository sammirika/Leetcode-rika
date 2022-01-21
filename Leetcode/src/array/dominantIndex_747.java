package array;

/**
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 至少是数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 */
public class dominantIndex_747 {

    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        // 排序
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, len);
        quickSort(temp, 0, len - 1);
        if (temp[len - 1] < temp[len - 2] * 2) {
            return -1;
        }
        for (int i = 0; i < len; i++) {
            if (temp[len - 1] == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int val = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[r] >= val) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= val) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = val;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }
}
