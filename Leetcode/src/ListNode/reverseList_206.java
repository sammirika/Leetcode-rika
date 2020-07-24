package ListNode;

import day.ListNode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 ******/
public class reverseList_206 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode temp = reverseList(node);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        //定义三个节点，前驱，当前和next
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            //让当前节点指向前驱
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
