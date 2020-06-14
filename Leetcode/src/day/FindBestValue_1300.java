package day;

import java.util.Arrays;

/**
 *
 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。

 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。

 请注意，答案不一定是 arr 中的数字。

 示例 1：

 输入：arr = [4,9,3], target = 10
 输出：3
 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 示例 2：

 输入：arr = [2,3,5], target = 10
 输出：5
 示例 3：

 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 输出：11361
 [1547,83230,57084,93444,70879]
 71237
 * ****/

public class FindBestValue_1300 {
    public static void main(String[] args) {
        System.out.println(findBestValue(new int[]{60864,25176,27249,21296,20204},56803));
    }

    //这里分两种情况，要没是数组中的值，要么就是平均值
    public static int findBestValue(int[] arr, int target) {
        //先对数组进行排序,使其相对有序
        Arrays.sort(arr);
        int len = arr.length;

        //遍历数组，同时判断剩余目标值的平均数是否小于当前遍历到到数组中的，
        // 如果是，就返回这个平均数，因为只能取整数，所以还要考虑平均数+1的可能性
        int diff = 0;
        for(int i=0;i<len;i++){
            //均摊平均值,四舍五入一下
            int temp = target/(len-i);
            System.out.println(temp);
            //只要存在更新后的target平均值小于剩下数组的开头，那么就可以直接进行判断
            if(temp<=arr[i]){
                //判断大小
                diff = Math.abs(target - temp*(len-i));
                if(Math.abs(target-(temp+1)*(len-i))<diff){
                    return temp+1;
                }
                return temp;
            }
            if (i==len-1){
                return arr[i];
            }
            //每次更新target
            target = target - arr[i];
        }
        return 0;
    }
}
