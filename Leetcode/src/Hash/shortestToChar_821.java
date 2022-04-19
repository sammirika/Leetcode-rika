package Hash;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 * 示例 1：
 * <p>
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 * 示例 2：
 * <p>
 * 输入：s = "aaab", c = "b"
 * 输出：[3,2,1,0]
 */
public class shortestToChar_821 {

    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];
        boolean[] visit = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
                visit[i] = true;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int left = index - 1;
            int right = index + 1;
            if (left >= 0 && !visit[left]) {
                ans[left] = ans[index] + 1;
                queue.add(left);
                visit[left] = true;
            }
            if (right < len && !visit[right]) {
                ans[right] = ans[index] + 1;
                queue.add(right);
                visit[right] = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        shortestToChar_821 kobe = new shortestToChar_821();
        int[] ret = kobe.shortestToChar("loveleetcode", 'e');
        for (int num : ret) {
            System.out.print(num + " ");
        }
    }
}
