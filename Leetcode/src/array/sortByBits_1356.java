package array;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 **/
public class sortByBits_1356 {

    public int[] sortByBits(int[] arr) {
        // 使用比较器
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return getCount(o1) == getCount(o2) ? o1 - o2 : getCount(o1) - getCount(o2);
            }
        });
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = nums[i];
        }
        return res;

    }

    private int getCount(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 2;
            num /= 2;
        }
        return res;
    }
}
