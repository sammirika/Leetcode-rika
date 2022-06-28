package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 */
public class wiggleSort_324 {

    public void wiggleSort(int[] nums) {
        // 可以先排序
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int right = n - 1;
        int left = right / 2;
        int[] temp = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++) {
            nums[i] = i % 2 == 0 ? temp[left--] : temp[right--];
        }
    }

    public static void main(String[] args) {
        wiggleSort_324 kobe = new wiggleSort_324();
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        kobe.wiggleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
