package ListNode;


/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * ****/
import day.ListNode;

import java.util.HashSet;
import java.util.Set;

public class removeDuplicateNodes_0201 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(1);
        ListNode post = removeDuplicateNodes(node);
        while (post!=null){
            System.out.println(post.val);
            post = post.next;
        }

    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        if (head==null){
            return head;
        }
        //加入头节点值
        set.add(head.val);
        //定义消耗节点
        ListNode post = head;
        while (post.next != null){
            ListNode cur = post.next;
            //add方法判断
            if (set.add(cur.val)){
                post = post.next;
            }else {
                post.next = post.next.next;
            }
        }
        post.next = null;
        return head;
    }
}
