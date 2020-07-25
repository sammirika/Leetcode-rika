package ListNode;

import day.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 ****/
public class swapPairs_24 {

    public static void main(String[] args) {
        ListNode Q = new ListNode(1);
        Q.next = new ListNode(2);
        Q.next.next = new ListNode(3);
        Q.next.next.next = new ListNode(4);
        ListNode P = swapPairs(Q);
        while (P != null) {
            System.out.println(P.val);
            P = P.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        //定义前驱节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.next != null) {
            //定义三个指针分别指向顺序的三个节点
            ListNode p1 = pre.next;
            ListNode p2 = p1.next;
            ListNode p3 = p2.next;

            //变化指针位置p2->p1 p1->p3 pre = p3
            p2.next = p1;
            pre.next = p2;
            p1.next = p3;

            pre = p1;

        }
        return dummyHead.next;
    }
}
