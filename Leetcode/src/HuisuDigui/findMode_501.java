package HuisuDigui;

import day.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 * ***/
public class findMode_501 {

    Map<Integer, Integer> map = new HashMap<>();
    int res = 1;

    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
            if (temp.getValue() == res) {
                list.add(temp.getKey());
            }
        }
        int[] num = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            num[i] = list.get(i);
        }
        return num;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(root.val)) {
            map.put(root.val, 1);
        } else {
            map.put(root.val, map.get(root.val) + 1);
            res = Math.max(res, map.get(root.val));
        }
        dfs(root.left);
        dfs(root.right);
    }

}
