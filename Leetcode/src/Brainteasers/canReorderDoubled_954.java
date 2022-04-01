package Brainteasers;

import java.util.*;

/**
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 */
public class canReorderDoubled_954 {

    static int N = 100010;
    static int M = 2 * N;
    static int[] cnt = new int[2 * M];

    public boolean canReorderDoubled(int[] arr) {
        Arrays.fill(cnt, 0);
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (++cnt[num + M] == 1) {
                list.add(num);
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        for (int num : list) {
            if (cnt[num * 2 + M] < cnt[num + M]) {
                return false;
            }
            cnt[num * 2 + M] -= cnt[num + M];
        }
        return true;
    }

}
