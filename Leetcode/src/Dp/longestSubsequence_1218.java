package Dp;

import java.util.*;

/**
 * 给你一个整数数组 arr 和一个整数 difference，
 * 请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 */
public class longestSubsequence_1218 {

    public static int longestSubsequence(int[] arr, int difference) {
        int len = arr.length;
        if (len < 2) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        map.put(arr[0], 1);
        int ret = 0;
        for (int i = 1; i < len; i++) {
            int num = arr[i] - difference;
            if (map.keySet().contains(num)) {
                dp[i] = map.get(num) + 1;
            }
            map.put(arr[i], dp[i]);
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, -3, -2, -4};
        System.out.println(longestSubsequence(array, -5));
    }
}
