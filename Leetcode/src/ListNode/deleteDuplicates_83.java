package ListNode;

import day.ListNode;

import javax.naming.NamingEnumeration;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 ****/
public class deleteDuplicates_83 {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(1);
        A.next.next = new ListNode(2);
        A.next.next.next = new ListNode(3);
        ListNode B = deleteDuplicates(A);
        while (B != null) {
            System.out.println(B.val);
            B = B.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        // 递归解决
        if (head == null || head.next == null){
            return head;
        }
        ListNode Next = head.next;
        if (Next.val == head.val){
            head = deleteDuplicates(Next);
        }else {
            head.next = deleteDuplicates(Next);
        }
        return head;
    }
}
