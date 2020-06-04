package day;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 示例:
 输入: [1,2,3,4]
 输出: [24,12,8,6]
 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * ****/
public class ProductExceptSelf_238 {
    public static void main(String[] args) {
        int[] array = productExceptSelf(new int[]{1,2,3,4});
        for (int a:array){
            System.out.println(a);
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        //定义输出数组
        int[] output = new int[nums.length];
        //定义左边乘积数组
        int[] left = new int[nums.length];
        //定义右边乘积数组
        int[] right = new int[nums.length];
        //0和nums.length左边,右边没数字
        left[0] = 1;
        for (int i=1;i<nums.length;i++){
            left[i] = left[i-1]*nums[i-1];
        }
        right[nums.length-1] = 1;
        for (int i=nums.length-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        for (int i=0;i<nums.length;i++){
            output[i] = left[i] * right[i];
        }
        return output;
    }
}
