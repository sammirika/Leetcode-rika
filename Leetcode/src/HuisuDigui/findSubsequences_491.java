package HuisuDigui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例:
 * <p>
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 ***/
public class findSubsequences_491 {

    private Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        dfs(nums, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }

    private void dfs(int[] nums, List<Integer> list, int index) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }
        // 出口
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                dfs(nums, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
