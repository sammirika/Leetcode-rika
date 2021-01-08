package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * ***/
public class rotate_189 {

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        Queue<Integer> res = new LinkedList<>();
        if (k == nums.length) {
            return;
        }
        int index = len - k;
        for (int j = index; j < len; j++) {
            res.add(nums[j]);
        }
        for (int i = 0; i < index; i++) {
            res.add(nums[i]);
        }
        for (int i = 0; i < len; i++) {
            nums[i] = res.poll();
        }
    }
}
