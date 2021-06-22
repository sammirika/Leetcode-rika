package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_622 {

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * <p>
     * 示例:
     * <p>
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     */
    private int len;

    private List<String> list = new ArrayList<>();

    public String[] permutation(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        boolean[] visit = new boolean[s.length()];
        len = array.length;
        dfs(array, 0, new StringBuilder(), visit);
        return list.toArray(new String[0]);
    }

    private void dfs(char[] array, int index, StringBuilder str, boolean[] visit) {
        if (index == len) {
            list.add(str.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visit[i]) {
                if (i > 0 && !visit[i - 1] && array[i - 1] == array[i]) {
                    continue;
                }
                visit[i] = true;
                str.append(array[i]);
                dfs(array, index + 1, str, visit);
                visit[i] = false;
                str.deleteCharAt(str.length() - 1);
            }
        }
    }


    /**
     * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
     * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * 请你找出符合题意的 最短 子数组，并输出它的长度。
     * 示例 1：
     * <p>
     * 输入：nums = [2,6,4,8,10,9,15]
     * 输出：5
     * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,4]
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int R = 0;
        int L = 0;
        // 找到右边索引
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) {
                R = i;
            }
            max = Math.max(max, nums[i]);
        }
        // 找到左边索引
        for (int i = nums.length - 1; i >= 0; i--) {
            if (min < nums[i]) {
                L = i;
            }
            min = Math.min(min, nums[i]);
        }
        return L == R ? 0 : R - L + 1;
    }
}
