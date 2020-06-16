package ListNode;

import day.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5
 * 示例 1:
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 * *****/
public class nextLargerNodes_1019 {
    public static void main(String[] args) {
        ListNode A = new ListNode(2);
        A.next = new ListNode(7);
        A.next.next = new ListNode(4);
        A.next.next.next = new ListNode(3);
        A.next.next.next.next = new ListNode(5);
        int[] array = nextLargerNodes2(A);
        for (int a:array){
            System.out.println(a);
        }
    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int[] array = new int[list.size()];
        for (int i=0;i<array.length;i++){
            int temp = list.get(i);
            for(int j=i+1;j<array.length;j++){
                if(list.get(j)>temp){
                    temp = list.get(j);
                    break;
                }
            }
            array[i] = temp>list.get(i)?temp:0;
        }
        return array;
    }
    //也可以套用单调栈解决
    public static int[] nextLargerNodes2(ListNode head){
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int[] array = new int[list.size()];
        //栈里面保存的是下标
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<list.size();i++){
            while (!stack.empty() && list.get(stack.peek())<list.get(i)){
                //出栈
                array[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        //递减栈中的元素全部归零
        while (!stack.empty()){
            array[stack.pop()] = 0;
        }
        return array;
    }
}
