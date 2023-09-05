package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,1,3], nums2 = [5,7]
 * 输出：15
 * 解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
 * 输出：3
 * 解释：数字 3 的数位 3 在两个数组中都出现了。
 */
public class minNumber_2605 {

    public int minNumber(int[] nums1, int[] nums2) {
        int m = Integer.MAX_VALUE;
        int n = Integer.MAX_VALUE;
        int ret = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            m = Math.min(m, num);
            set.add(num);
        }
        for (int num : nums2) {
            n = Math.min(n, num);
            if (set.contains(num)) {
                ret = Math.min(ret, num);
            }
        }
        if (ret != Integer.MAX_VALUE) {
            return ret;
        }
        if (m < n) {
            ret = m * 10 + n;
        } else {
            ret = n * 10 + m;
        }
        return ret;
    }
}
