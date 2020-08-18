package HuisuDigui;

import day.ListNode;
import day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 ****/


public class sortedListToBST_109 {

    //转成列表再进行递归
    List<Integer> list = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        this.list = list;
        return dfs(0, list.size());
    }

    //递归,左开右闭的区间来构造
    private TreeNode dfs(int left, int right) {
        if (left >= right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfs(left, mid);
        root.right = dfs(mid + 1, right);
        return root;
    }
}
