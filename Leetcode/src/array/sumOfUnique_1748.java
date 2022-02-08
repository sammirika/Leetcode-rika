package array;

/**
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * <p>
 * 请你返回 nums 中唯一元素的 和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 */
public class sumOfUnique_1748 {

    public int sumOfUnique(int[] nums) {
        int[] hash = new int[101];
        for (int num : nums) {
            hash[num]++;
        }
        int ret = 0;
        for (int num : nums) {
            if (hash[num] == 1) {
                ret += num;
            }
        }
        return ret;
    }
}
