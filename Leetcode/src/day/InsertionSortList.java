package day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class day.ListNode {
 *     int val;
 *     day.ListNode next;
 *     day.ListNode(int x) { val = x; }
 * }
 *
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 */

public class InsertionSortList {

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        ListNode kobe = InsertionSortList.insertionSortList(node);
        while(kobe!=null){
            System.out.print(kobe.val+"->");
            kobe = kobe.next;
        }
    }


    public static ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int[] array = new int[list.size()];
        for (int i=0;i<list.size();i++){
            array[i] = list.get(i);
        }
        //两两交换就是插入的精髓
        Arrays.sort(array);
        ListNode A = new ListNode(0);
        ListNode B = A;
        for(int i=0;i<array.length;i++){
            B.next = new ListNode(array[i]);
            B = B.next;
        }
        return A.next;
    }
}
