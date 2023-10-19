package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。
 * 其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,4,6]
 * 输出：8
 * 解释：存在 8 个满足题意的元组：
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 */
public class tupleSameProduct_1726 {

    public int tupleSameProduct(int[] nums) {
        // hash解决
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 记录所有乘积
                int mult = nums[i] * nums[j];
                if (map.containsKey(mult)) {
                    map.put(mult, map.get(mult) + 1);
                } else {
                    map.put(mult, 1);
                }
            }
        }

        // 计算
        int ret = 0;
        for (int x : map.keySet()) {
            // 乘积的个数
            int y = map.get(x);
            if (y == 1)
                continue;
            ret += (y * (y - 1)) / 2;
        }
        // 4个数字排列组合
        return ret * 8;
    }
}
