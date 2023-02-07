package ListNode;

import day.ListNode;

/**
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * 下图中蓝色边和节点展示了操作后的结果：
 * 请你返回结果链表的头指针。
 * 示例 1：
 * <p>
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * 示例 2：
 * <p>
 * <p>
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 */
public class mergeInBetween_1669 {


    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nodea = list1;
        for (int i = 0; i < a - 1; i++) {
            nodea = nodea.next;
        }
        ListNode nodeb = nodea.next;
        for (int i = a; i < b; i++) {
            nodeb = nodeb.next;
        }
        nodeb = nodeb.next;
        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }
        nodea.next = list2;
        tail.next = nodeb;
        return list1;
    }
}
