package review;

import java.lang.reflect.Array;
import java.util.*;

public class Solution_410 {

    /**
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     * 示例 1：
     * <p>
     * 输入：n = 6
     * 输出：true
     * 解释：6 = 2 × 3
     * 示例 2：
     * <p>
     * 输入：n = 8
     * 输出：true
     * 解释：8 = 2 × 2 × 2
     */
    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    /**
     * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
     * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
     * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
     * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
     * 解释：
     * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
     * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
     * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
     * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
     * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return people;
        }
        // 第一次排序，以身高为基准排序，身高相同时排序index的值
        // 排序后变为[7,1],[7,0],[6,1],[5,2],[5,0],[4,4];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        // 使用队列插入排序
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] temp : people) {
            queue.add(temp[1], temp);
        }
        return queue.toArray(new int[people.length][2]);
    }

    /**
     * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列
     * 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
     * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
     * <p>
     * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
     * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，
     * 你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：false
     * 解释：序列中不存在 132 模式的子序列。
     * 示例 2：
     * <p>
     * 输入：nums = [3,1,4,2]
     * 输出：true
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int last = Integer.MIN_VALUE;
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            // 出现1模式了
            if (nums[i] < last) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                last = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
     * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * 示例 1：
     * <p>
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 示例 2：
     * <p>
     * 输入：s = "a", t = "a"
     * 输出："a"
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) {
            return "";
        }
        int[] table = new int[128];
        int[] window = new int[128];
        // 填充table
        for (char ch : t.toCharArray()) {
            table[ch]++;
        }

        // 开始滑动
        int right = 0;
        int len = s.length();
        int left = 0;
        int count = 0;
        String str = "";
        int minLen = s.length() + 1;
        while (right < len) {
            char ch = s.charAt(right);
            window[ch]++;
            if (table[ch] > 0 && table[ch] >= window[ch]) {
                count++;
            }
            // window内含有字母达标
            while (count == t.length()) {
                ch = s.charAt(left);
                if (table[ch] > 0 && table[ch] >= window[ch]) {
                    count--;
                }
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    str = s.substring(left, right + 1);
                }
                window[ch]--;
                left++;
            }
            right++;
        }
        return str;
    }
}
