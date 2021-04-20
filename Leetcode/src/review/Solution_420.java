package review;

import java.util.*;

public class Solution_420 {

    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * 说明：
     * <p>
     * 无空格字符构成一个 单词 。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * 示例 1：
     * <p>
     * 输入："the sky is blue"
     * 输出："blue is sky the"
     */
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        List<String> list = new ArrayList<>();
        int right = 0;
        StringBuilder str = new StringBuilder();
        while (right < s.length()) {
            if (s.charAt(right) == ' ') {
                right++;
                continue;
            }
            while (right < s.length() && s.charAt(right) != ' ') {
                str.append(s.charAt(right++));
            }
            if (str.length() > 0) {
                list.add(str.toString());
                str = new StringBuilder();
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = list.size() - 1; i > 0; i--) {
            res.append(list.get(i) + " ");
        }
        res.append(list.get(0));
        return res.toString();
    }

    /**
     * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列
     * 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
     * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
     * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
     * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，
     * 你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,3,4]
     * 输出：false
     * 解释：序列中不存在 132 模式的子序列。
     * 示例 2：
     * <p>
     * 输入：nums = [3,1,4,2]
     * 输出：true
     * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int len = nums.length - 1;
        // 第三个数
        int last = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = len; i >= 0; i--) {
            if (nums[i] < last) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                last = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    /**
     * 公司有编号为 1 到 n 的 n 个工程师，给你两个数组 speed 和 efficiency ，
     * 其中 speed[i] 和 efficiency[i] 分别代表第 i 位工程师的速度和效率。
     * 请你返回由最多 k 个工程师组成的 ​​​​​​最大团队表现值 ，由于答案可能很大，请你返回结果对 10^9 + 7 取余后的结果。
     * 团队表现值 的定义为：一个团队中「所有工程师速度的和」乘以他们「效率值中的最小值」。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
     * 输出：60
     * 解释：
     * 我们选择工程师 2（speed=10 且 efficiency=4）和工程师 5（speed=5 且 efficiency=7）。
     * 他们的团队表现值为 performance = (10 + 5) * min(4, 7) = 60 。
     */

    class Task {
        private int s;
        private int e;

        public Task(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = 1000000007;
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            taskList.add(new Task(speed[i], efficiency[i]));
        }
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o2.e - o1.e;
            }
        });
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.s - o2.s;
            }
        });
        long res = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            Task task = taskList.get(i);
            long minE = task.e;
            long sums = sum + task.s;
            res = Math.max(res, sums * minE);
            priorityQueue.add(task);
            sum += task.s;
            if (priorityQueue.size() == k) {
                sum -= priorityQueue.poll().s;
            }
        }
        return (int)(res%mod);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" hello world "));
    }
}
