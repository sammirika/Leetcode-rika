/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * **/

package ListNode;

import day.ListNode;

public class ListNode_19 {

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        ListNode B = removeNthFromEnd(A,2);
        while (B!=null){
            System.out.println(B.val);
            B = B.next;
        }
    }

    //快慢指针解决
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /**先定义一个前驱节点**/
        ListNode pre = new ListNode(0);
        pre.next = head;

        //定义快慢指针
        ListNode fast = pre;
        ListNode slow = pre;

        //快指针先跑
        while (n>=0){
            fast = fast.next;
            n--;
        }
        //慢指针加入一起跑，快指针到底即可
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }

}
