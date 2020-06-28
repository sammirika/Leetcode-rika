package array;
/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * ******/
public class minSubArrayLen_209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{7,3,1,2,4,3}));
    }
    //双指针解法
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int start=0,end=0;
        int sum = 0;
        //长度记录变量
        int res = Integer.MAX_VALUE;
        while (end<nums.length){
            sum += nums[end];
            while (sum>=s){
                res = Math.min(res,end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res==Integer.MAX_VALUE? 0:res;
    }
}
