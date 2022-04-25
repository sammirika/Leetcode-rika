package Hash;

import java.util.*;

/**
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * 示例:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 * <p>
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 */
public class Solution {

    int[] nums;
    Map<Integer, List<Integer>> map = new HashMap<>();

    public Solution(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (!map.containsKey(tmp)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(tmp, list);
            } else {
                List<Integer> list1 = map.get(tmp);
                list1.add(i);
                map.put(tmp, list1);
            }
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int randomIndex = new Random().nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3, 3});
        System.out.println(solution.pick(3));
    }
}
