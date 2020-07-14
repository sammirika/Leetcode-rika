package Dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *      [3,4],
 *      [6,5,7],
 *      [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * ******/
public class minimumTotal_120 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(){{
            add(2);
        }};
        List<Integer> list2 = new ArrayList<>(){{
            add(3);
            add(4);
        }};
        List<Integer> list3 = new ArrayList<>(){{
            add(6);
            add(5);
            add(7);
        }};
        List<Integer> list4 = new ArrayList<>(){{
            add(4);
            add(1);
            add(8);
            add(3);
        }};
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        System.out.println(minimumTotal(lists));

    }


    //想像成等腰直角三角形，自底向上的动态规划
    public static int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        //dp数组赋初值
        for (int i=0;i<len;i++){
            dp[i] = triangle.get(len-1).get(i);
        }
        for (int i=len-2;i>=0;i--){
            List<Integer> list = triangle.get(i);
            for (int j=0;j<=i;j++){
                dp[j] = list.get(j) + Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}
