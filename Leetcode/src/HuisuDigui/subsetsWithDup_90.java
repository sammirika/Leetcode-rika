package HuisuDigui;

import java.util.*;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 ***/
public class subsetsWithDup_90 {


    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(nums, list, 0);
        return new ArrayList<>(res);
    }

    private void dfs(int[] nums, List<Integer> list, int index) {
        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        subsetsWithDup_90 kobe = new subsetsWithDup_90();
        List<List<Integer>> lists = kobe.subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
