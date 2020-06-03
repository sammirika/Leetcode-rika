package day;
/**
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4,-1]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * ****/
public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(MaxProduct.maxProduct(new int[]{2,3,-2,4,-1}));
    }


    public static int maxProduct(int[] nums) {
        //max记录最大值
        int max = Integer.MIN_VALUE;
        //max_value和min_value用于当遇到负数的时候来回交换
        int max_value = 1;
        int min_value = 1;
        for (int i=0;i<nums.length;i++){
            //遇到了负数开始交换,也能保证之前的连续最大正整数乘积被max记录
            if(nums[i]<0){
                int temp = max_value;
                max_value = min_value;
                min_value = temp;
            }
            max_value = Math.max(nums[i],nums[i]*max_value);
            min_value = Math.min(nums[i],nums[i]*min_value);
            max = Math.max(max,max_value);
        }
        return max;
    }
}
