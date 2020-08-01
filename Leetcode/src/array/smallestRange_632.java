package array;

import day.ListNode;

import java.util.*;

/**
 * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * <p>
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 * <p>
 * 示例 1:
 * <p>
 * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出: [20,24]
 * 解释:
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 ****/
public class smallestRange_632 {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        Integer[] A = new Integer[]{4, 10, 15, 24, 26};
        Integer[] B = new Integer[]{0, 9, 12, 20};
        Integer[] C = new Integer[]{5, 18, 22, 30};
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(A));
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(B));
        List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(C));

        list.add(list1);
        list.add(list2);
        list.add(list3);
        smallestRange_632 kobe = new smallestRange_632();
        int[] nums = kobe.smallestRange(list);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int inf = 100000;
        int max = -inf; // 当前最大值
        int start = -inf;  // 起点
        int end = inf;   // 终点

        //定义小顶堆,以val的值来判断
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });

        //将k个列表中的第一个元素存进堆里,同时更新max的值
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            queue.add(new Node(i, 0, val));
            max = Math.max(max, val);
        }

        //利用优先队列的最小堆特性，找到最小区间
        while (queue.size() == k) {
            Node node = queue.poll();
            int i = node.i;
            int j = node.j;
            int val = node.val;

            //更新区间
            if (max - val < end - start) {
                start = val;
                end = max;
            }

            //每次都从列表中找到元素更新堆中的结构,更新max的值,由于是小顶，
            // 保证每一次都是不同的list,也保证了最小元素的列表能被遍历完
            if (j + 1 < nums.get(i).size()) {
                int temp = nums.get(i).get(j + 1);
                queue.add(new Node(i, j + 1, temp));
                max = Math.max(max, temp);
            }
        }
        return new int[]{start, end};

    }

    //定义i，j,val分别代表第i个列表，对应列表中第j个元素和其自己的权值
    class Node {
        private int i;
        private int j;
        private int val;

        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}
