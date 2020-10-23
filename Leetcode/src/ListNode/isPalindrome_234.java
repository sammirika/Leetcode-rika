package ListNode;

import day.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * ***/
public class isPalindrome_234 {

    public static boolean isPalindrome(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        int len = res.size();
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (res.get(i).equals(res.get(j))) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
