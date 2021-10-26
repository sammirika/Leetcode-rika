package array;

import java.util.*;

/**
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1
 */
public class nextGreaterElement_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums2.length - 1;
        map.put(nums2[n], -1);
        int max = nums2[n];
        Deque<Integer> queue = new LinkedList<>();
        queue.addFirst(max);
        for (int i = n - 1; i >= 0; i--) {
            if (nums2[i] > max) {
                map.put(nums2[i], -1);
                max = nums2[i];
            } else {
                for (Integer temp : queue) {
                    if (temp > nums2[i]) {
                        map.put(nums2[i], temp);
                        break;
                    }
                }
            }
            queue.addFirst(nums2[i]);
        }
        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = map.get(nums1[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        nextGreaterElement_496 kobe = new nextGreaterElement_496();
        int[] ret = kobe.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        System.out.println(ret[1]);
    }
}
