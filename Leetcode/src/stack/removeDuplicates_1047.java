package stack;

import day.ListNode;

import java.util.*;

/***
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * */
public class removeDuplicates_1047 {

    private int res;

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        if (S.length() <= 1) {
            return S;
        }
        for (char ch : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 进阶：
     * <p>
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     **/
    public void rotate(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        if (nums.length == 0 || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        for (int i = nums.length - k; i < nums.length; i++) {
            ((LinkedList<Integer>) queue).add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            ((LinkedList<Integer>) queue).add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.poll();
        }
    }


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     **/
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        char[] array = s.toCharArray();
        int n = array.length;
        int res = 0;
        int left = 0;
        int right = 0;
        while (left < n && right < n) {
            if (!set.contains(array[right])) {
                set.add(array[right]);
                right++;
                res = Math.max(right - left, res);
            } else {
                set.remove(array[left++]);
            }
        }
        return res;
    }



}
