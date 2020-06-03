package day;

/**
 * Definition for singly-linked list.
 * public class day.ListNode {
 *     int val;
 *     day.ListNode next;
 *     day.ListNode(int x) { val = x; }
 * }
 *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *
 */




public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode A = new ListNode(3);
        ListNode B = new ListNode(4);
        A.next = new ListNode(4);
        B.next = new ListNode(6);
        A.next.next = new ListNode(2);
        B.next.next = new ListNode(5);
        ListNode S = AddTwoNumbers.addTwoNumbers(A,B);
        while(S!=null){
            System.out.print(S.val + "->");
            S = S.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode aim = new ListNode(0);
        ListNode temp = aim;

        //变量用于记录进位数
        int jinwei = 0;
        while(l1 != null || l2!=null){
            //lamda表达式
            int A = l1==null? 0:l1.val;
            int B = l2==null? 0:l2.val;

            int sum = A+B+jinwei;
            jinwei = sum/10;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(jinwei==1){
            temp.next = new ListNode(1);
        }
        return aim.next;
    }
}
