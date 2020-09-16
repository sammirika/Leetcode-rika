package HuisuDigui;

import java.util.HashSet;
import java.util.Set;

/**
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。
 * 不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 *
 * 解释: 不能用所有火柴拼成一个正方形。
 * ****/
public class makesquare_473 {

    public boolean makesquare(int[] nums) {
        // 保存四条边的数组
        int len = nums.length;
        if (len==0 || len<4){
            return false;
        }
        int sum = 0;
        for (int num:nums){
            sum += num;
        }
        // 不能以四条边凑出来则直接返回false即可
        if (sum % 4 != 0){
            return false;
        }
        return dfs(nums,0,0,0,0,0,sum/4);
    }

    //
    private boolean dfs(int[] nums, int index,int a,int b,int c,int d,int side){
        // 递归结束条件，判断是否四条边正好每条边等于目的边
        if (index == nums.length){
            return a==side && b==side && c==side && d==side;
        }
        // 只要四边存在溢出直接返回
        if (a>side || b>side || c>side || d>side){
            return false;
        }
        //加上set剪枝
        Set<Integer> set = new HashSet<>();
        boolean res = false;
        if (!set.contains(a)){
            res = res || dfs(nums,index+1,a+nums[index],b,c,d,side);
            set.add(a);
        }
        if (!set.contains(b)){
            res = res || dfs(nums,index+1,a,b+nums[index],c,d,side);
            set.add(b);
        }
        if (!set.contains(c)){
            res = res || dfs(nums,index+1,a,b,c+nums[index],d,side);
            set.add(c);
        }
        if (!set.contains(d)){
            res = res || dfs(nums,index+1,a,b,c,d+nums[index],side);
            set.add(d);
        }
        return  res;
    }
}
