package ListNode;

import day.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 ******/
public class removeElements_203 {

    public static void main(String[] args) {
        ListNode C = new ListNode(1);
        C.next = new ListNode(6);
        C.next.next = new ListNode(6);
        C.next.next.next = new ListNode(4);
        ListNode D = removeElements(C, 6);
        while (D != null) {
            System.out.println(D.val);
            D = D.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        //也采用定义前驱节点的办法

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
