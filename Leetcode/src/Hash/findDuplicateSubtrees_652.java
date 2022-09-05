package Hash;

import day.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 给定一棵二叉树 root，返回所有重复的子树。
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * 示例 2：
 * <p>
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 */
public class findDuplicateSubtrees_652 {

    private Map<String, TreeNode> map = new ConcurrentHashMap<>();
    private Set<TreeNode> ret = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(ret);
    }

    private String dfs(TreeNode root) {
        // 递归出口
        if (root == null) {
            return "";
        }
        String key = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        if (map.containsKey(key)) {
            ret.add(map.get(key));
        } else {
            map.put(key, root);
        }
        return key;
    }

}
