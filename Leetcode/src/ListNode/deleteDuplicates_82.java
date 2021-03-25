package ListNode;

import day.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *****/
public class deleteDuplicates_82 {

    public static void main(String[] args) {
        ListNode M = new ListNode(1);
        M.next = new ListNode(1);
        M.next.next = new ListNode(1);
        M.next.next.next = new ListNode(2);
        M.next.next.next.next = new ListNode(3);
        ListNode N = deleteDuplicates(M);
        while (N != null) {
            System.out.println(N.val);
            N = N.next;
        }
    }

    //可以双指针，也可以hash表解决,也可以递归
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 递归解决
        ListNode next = head.next;
        if (head.val == next.val){
            while (next != null && head.val == next.val){
                next = next.next;
            }
            head = deleteDuplicates(next);
        }else {
            head.next = deleteDuplicates(next);
        }
        return head;
    }
}
