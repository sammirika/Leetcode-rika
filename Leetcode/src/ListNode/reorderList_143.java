package ListNode;
/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * ***/
import day.ListNode;

import java.util.LinkedList;

public class reorderList_143 {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        reorderList(A);
        while (A!=null){
            System.out.println(A.val);
            A = A.next;
        }
    }

    public static void reorderList(ListNode head) {
        //使用队列或者栈求解
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode node = head;
        while (node!=null){
            queue.add(node);
            node = node.next;
        }
        //再用队列构造一个链表
        while (!queue.isEmpty()){
            if (node==null){
                //取出队列中的第一个点
                node = queue.pollFirst();
            }else{
                node.next= queue.pollFirst();
                node = node.next;
            }
            //取出最后面的，依次交替
            node.next = queue.pollLast();
            node = node.next;
        }
        if (node!=null){
            node.next = null;
        }
    }
}
