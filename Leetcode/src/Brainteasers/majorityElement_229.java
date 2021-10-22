package Brainteasers;

import java.util.*;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：[3]
 * <p>
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 */
public class majorityElement_229 {

    public List<Integer> majorityElement(int[] nums) {
        int count = nums.length / 3;
        Set<Integer> ret = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > count) {
                ret.add(num);
            }
        }
        return new ArrayList<>(ret);
    }

    public static void main(String[] args) {
        majorityElement_229 kobe = new majorityElement_229();
        System.out.println(kobe.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
