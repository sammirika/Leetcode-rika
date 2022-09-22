package tanxin;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，
 * 其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * 示例 1：
 * <p>
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 2：
 * <p>
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * 示例 3：
 * <p>
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 */
public class canFormArray_1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        // hash表
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            // 题目保证唯一性
            map.put(piece[0], piece);
        }
        for (int i = 0; i < arr.length;) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            // 用数组匹配
            int[] tmp = map.get(arr[i]);
            for (int j = 0; j < tmp.length; j++, i++) {
                if (tmp[j] != arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
