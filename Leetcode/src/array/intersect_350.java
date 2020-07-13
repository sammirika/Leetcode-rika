package array;

import java.util.Arrays;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * *******/
public class intersect_350 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] nums = intersect(nums1,nums2);
        for (int num:nums){
            System.out.println(num);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        //使两个数组相对有序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[Math.min(nums1.length,nums2.length)];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        //类似于合并
        while (index1<nums1.length && index2< nums2.length){
            if (nums1[index1]<nums2[index2]){
                index1++;
            }else if (nums1[index1]>nums2[index2]){
                index2++;
            }else {
                //相等的情况
                res[index3++] = nums1[index1++];
                index2++;
            }
        }
        return Arrays.copyOfRange(res,0,index3);
    }
}
