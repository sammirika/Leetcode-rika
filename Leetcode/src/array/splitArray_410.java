package array;

import java.util.Arrays;

/**
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * 注意:
 * 数组长度 n 满足以下条件:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 * <p>
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * 输出:
 * 18
 * <p>
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 ****/
public class splitArray_410 {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 5, 10, 8};
        System.out.println(splitArray(nums, 2));
    }

    //二分查找，这里的大小由数组中的最大值和整个数组和来确定
    public static int splitArray(int[] nums, int m) {
        //先排序,使得相对有序，[2,5,7,8,10]
        Arrays.sort(nums);

        long left = 0;
        long right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }


        //二分查找
        while (left < right) {
            //取中值
            long mid = (left + right) >> 1;

            //新建变量记录每次的数组能分的值
            int count = 0;
            int sum = 0;

            for (int num : nums) {
                //贪心求分割数组个数
                if (sum + num > mid) {
                    count++;
                    sum = 0;
                }
                sum += num;
            }
            count++;
            if (count <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }
}
