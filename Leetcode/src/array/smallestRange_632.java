package array;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 *
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 *
 * 示例 1:
 *
 * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出: [20,24]
 * 解释:
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 *
 * ****/
public class smallestRange_632 {

    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int inf = 0x3f3f3f;
        int max = -inf; // 当前最大值
        int st = -inf;  // 起点
        int ed = inf;   // 终点

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));

        // 相当于合并k个有序链表，把 head 放进去
        for (int i = 0; i < n; i++) {
            int val = nums.get(i).get(0);
            pq.offer(new Node(i, 0, val));
            max = Math.max(max, val);
        }

        // 必须包含 k 个元素
        while (pq.size() == n) {
            Node node = pq.poll();
            int i = node.i;
            int j = node.j;
            int val = node.val;

            // 更新区间长度
            if (max - val < ed - st) {
                st = val;
                ed = max;
            }

            // 为堆中填充元素
            if (j + 1 < nums.get(i).size()) {
                int nVal = nums.get(i).get(j + 1);
                pq.offer(new Node(i, j + 1, nVal));
                max = Math.max(max, nVal);
            }
        }
        return new int[]{st, ed};

    }

    class Node{
        int i, j, val;

        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}
