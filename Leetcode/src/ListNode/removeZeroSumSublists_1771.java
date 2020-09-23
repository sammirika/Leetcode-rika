package ListNode;

import day.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 *  
 *
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 *
 * 示例 1：
 *
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 *
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 *
 * *****/
public class removeZeroSumSublists_1771 {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        // 记录前缀和，如果存在前缀和相等则直接跳过两个前缀和之间的结点
        int sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }
        sum = 0;
        // 链表操作，跳过连续和为0的点
        for (ListNode m = dummy; m != null; m = m.next) {
            sum += m.val;
            // 跳过操作
            m.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
