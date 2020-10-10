package ListNode;

import day.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * <p>
 * 你是否可以不用额外空间解决此题？
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 ****/
public class detectCycle_142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            if (!map.containsKey(p)) {
                map.put(p, p.val);
            } else {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
