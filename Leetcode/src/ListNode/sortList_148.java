package ListNode;

import day.ListNode;
import javafx.scene.shape.Sphere;

import java.util.ArrayList;
import java.util.List;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * ****/
public class sortList_148 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(4);
        ListNode root = sortList_148.sortList(node);
        while (root!=null){
            System.out.println(root.val);
            root = root.next;
        }
    }

    //归并排序
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }


    //对数组进行快速排序,复杂度可以满足上面的要求
    private static void quickSort(int left, int right, int[] array){
        //结束条件
        if (left>right){
            return;
        }
        int l = left;
        int r = right;
        int key = array[left];
        while (l<r){
            while (l<r && array[r]>=key){
                r--;
            }
            array[l] = array[r];
            while (l<r && array[l]<=key){
                l++;
            }
            array[r] = array[l];
        }
        array[l] = key;
        quickSort(left,l-1,array);
        quickSort(r+1,right,array);
    }
}
