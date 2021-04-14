package review;

import day.ListNode;
import day.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_414 {

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
     * 并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例 1：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     * <p>
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        // 进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int A = l1 == null ? 0 : l1.val;
            int B = l2 == null ? 0 : l2.val;
            int sum = A + B + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new ListNode(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (carry == 1) {
            temp.next = new ListNode(1);
        }
        return dummy.next;
    }

    /**
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
     * 例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
     * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
     * 题目数据保证答案肯定是一个 32 位 的整数。
     * 示例 1：
     * <p>
     * 输入：s = "12"
     * 输出：2
     * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 示例 2：
     * <p>
     * 输入：s = "226"
     * 输出：3
     * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     */
    public int numDecodings(String s) {
        final int length = s.length();
        if (length == 0) return 0;
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 0; i < length; i++) {
            dp[i + 1] = s.charAt(i) == 0 ? 0 : dp[i];
            if (i > 0 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= 6))) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[length - 1];
    }


    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     * <p>
     * 1            <---
     * /   \
     * 2     3         <---
     * \     \
     * 5     4       <---
     */
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list.get(list.size() - 1));
            list = new ArrayList<>();
        }
        return res;
    }
}
