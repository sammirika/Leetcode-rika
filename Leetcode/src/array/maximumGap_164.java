package array;

import java.util.Arrays;

public class maximumGap_164 {


    /***
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
     *
     * 如果数组元素个数小于 2，则返回 0。
     *
     * 示例 1:
     *
     * 输入: [3,6,9,1]
     * 输出: 3
     * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
     *
     * ****/
    public int maximumGap(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i=1;i<nums.length;i++){
            res = Math.max(res,nums[i]-nums[i-1]);
        }
        return res;
    }
}
