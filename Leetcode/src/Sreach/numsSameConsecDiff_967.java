package Sreach;

import java.util.*;

/***
 * 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
 * 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，
 * 所以是无效的；但 0 是有效的。
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：n = 3, k = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 *
 */
public class numsSameConsecDiff_967 {

    public int[] numsSameConsecDiff(int n, int k) {
        // 广度优先搜索，将数字划分为一层一层
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            queue.add(i);
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer val = queue.pollFirst();
            if (String.valueOf(val).length() == n) {
                list.add(val);
                continue;
            }
            int mod = val % 10;
            if (mod - k >= 0) {
                queue.add(val * 10 + mod - k);
            }
            if (k > 0 && mod + k <= 9) {
                queue.add(val * 10 + mod + k);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
