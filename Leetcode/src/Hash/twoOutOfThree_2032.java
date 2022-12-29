package Hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，
 * 且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * 输出：[3,2]
 * 解释：至少在两个数组中出现的所有值为：
 * - 3 ，在全部三个数组中都出现过。
 * - 2 ，在数组 nums1 和 nums2 中出现过。
 * <p>
 * 提示：
 * 1 <= nums1.length, nums2.length, nums3.length <= 100
 * 1 <= nums1[i], nums2[j], nums3[k] <= 100
 */
public class twoOutOfThree_2032 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        // hash
        int[] hash1 = new int[101];
        int[] hash2 = new int[101];
        int[] hash3 = new int[101];
        for (int num : nums1) {
            if (hash1[num] == 0) {
                hash1[num]++;
            }
        }
        for (int num : nums2) {
            if (hash2[num] == 0){
                hash2[num]++;
            }
        }
        for (int num : nums3) {
            if (hash3[num] == 0){
                hash3[num]++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (hash1[i] + hash2[i] + hash3[i] >= 2) {
                list.add(i);
            }
        }
        return list;
    }
}
