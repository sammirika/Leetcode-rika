package String;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *
 * 示例 1：
 *
 * 输入: ["23:59","00:00"]
 * 输出: 1
 *
 * ["05:31","22:08","00:35"]
 * 147
 *
 * *****/
public class findMinDifference_539 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("05:31");
        list.add("22:08");
        list.add("00:35");
        System.out.println(findMinDifference(list));
    }


    public static int findMinDifference(List<String> timePoints) {
        int[] nums = new int[timePoints.size()];
        for (int i=0;i<nums.length;i++){
            String str = timePoints.get(i);
            //将每个时刻转化为分钟
            nums[i] = (str.charAt(0)-'0')*600 + (str.charAt(1) -'0')*60 + (str.charAt(3) - '0')*10 + (str.charAt(4)-'0');
        }
        Arrays.sort(nums);
        //注意第一个和最后一个的时间差值可能是逆时针
        int res = nums[0] + 1440 - nums[nums.length-1];
        for (int i=1;i<nums.length;i++){
            res = Math.min(res,nums[i]-nums[i-1]);
        }
        return res;
    }
}
