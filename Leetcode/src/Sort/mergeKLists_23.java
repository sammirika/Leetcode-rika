package Sort;

import day.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *****/
public class mergeKLists_23 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        ListNode[] lists = new ListNode[3];
        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;
        ListNode root = mergeKLists(lists);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        //优先队列小顶堆解决
        if (lists.length == 0) {
            return null;
        }
        //定义虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        //bfs
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            cur.next = new ListNode(temp.val);
            cur = cur.next;
            //将最小的节点的下一个节点加入队列中
            if (temp.next != null) {
                queue.add(temp.next);
            }
        }
        return dummyHead.next;
    }
}
