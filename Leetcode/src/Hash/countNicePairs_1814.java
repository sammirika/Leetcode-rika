package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组 nums ，数组中只包含非负整数。
 * 定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。
 * 比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * <p>
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 * - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 * - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 */
public class countNicePairs_1814 {

    public int countNicePairs(int[] nums) {
        // 转化为求差对 nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        int len = nums.length;
        int[] diff = new int[len];
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            int temp = 0;
            while (num > 0) {
                temp = temp * 10 + num % 10;
                num /= 10;
            }
            diff[i] = temp - nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;

        for (int dif : diff) {
            map.put(dif, map.getOrDefault(dif, 0) + 1);
        }

        // 根据有多少相同数算对数
        for (int value : map.values()) {
            ret += ((long) value * (value - 1) / 2) % 1000000007;
        }
        return  ret % 1000000007;
    }
}
