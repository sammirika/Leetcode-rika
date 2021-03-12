package review;

import java.util.PriorityQueue;
import java.util.Queue;

/***
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * **/
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for(int num:nums){
            if(sum>0){
                sum += num;
            }else{
                sum = num;
            }
            max = Math.max(max,sum);
        }
        return max;
    }

    /***
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，
     * 这样它就有足够的空间保存来自 nums2 的元素。 
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i=0;i<m;i++){
            priorityQueue.add(nums1[i]);
        }
        for (int i=0;i<n;i++){
            priorityQueue.add(nums2[i]);
        }
        for (int i=0;i<m+n;i++){
            nums1[i] = priorityQueue.poll();
        }
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
