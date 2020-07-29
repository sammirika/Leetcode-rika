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
        ListNode Aa = new ListNode(1);
        Aa.next = new ListNode(2);
        Aa.next.next = new ListNode(3);
        Aa.next.next.next = new ListNode(4);
        Aa.next.next.next.next = new ListNode(5);
        ListNode B = removeNthFromEnd(Aa,2);
        while (B!=null){
            System.out.println(B.val);
            B = B.next;
        }
    }

    //快慢指针解决,删除掉第N个节点
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

    //两次遍历解法
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        //先扫描出整个链表的长度
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        //正数第几个
        count -= n;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (count > 0) {
            pre = pre.next;
            count--;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }

}
