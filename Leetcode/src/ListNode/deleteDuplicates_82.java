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

    //可以双指针，也可以hash表解决
    public static ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        //先记录重复元素,重复元素的value的值记为-1
        ListNode temp = head;
        while (temp != null) {
            if (map.containsKey(temp.val)) {
                map.put(temp.val, -1);
            } else {
                map.put(temp.val, 1);
            }
            temp = temp.next;
        }
        //涉及到头节点的操作都得定义一个虚拟的前驱节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            //删除操作
            if (map.get(cur.next.val) != 1) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
