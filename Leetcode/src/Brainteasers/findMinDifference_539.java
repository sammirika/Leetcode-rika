package Brainteasers;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 * 示例 1：
 * <p>
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 */
public class findMinDifference_539 {

    public int findMinDifference(List<String> timePoints) {
        // 每个时刻转化为分钟
        int[] nums = new int[timePoints.size()];
        int index = 0;
        for (String str : timePoints) {
            nums[index++] = (str.charAt(0) - '0') * 600 + (str.charAt(1) - '0') * 60 + (str.charAt(3) - '0') * 10
                    + (str.charAt(4) - '0');
        }
        // 排序
        Arrays.sort(nums);
        // 算最小的减最大的，有可能遇到这个差值最小
        int ret = nums[0] + 1440 - nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            ret = Math.min(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
}
