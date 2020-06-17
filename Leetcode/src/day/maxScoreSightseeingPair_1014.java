package day;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * ***/
public class maxScoreSightseeingPair_1014 {

    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair2(new int[]{8,1,5,2,6}));
    }
    //暴力破解，超出时间限制
    public static int maxScoreSightseeingPair(int[] A) {
        int max = 0;
        for(int i=0;i<A.length;i++){
            for (int j=i+1;j<A.length;j++){
                max = Math.max(max,A[i]+A[j]+i-j);
            }
        }
        return max;
    }
    //动态规划维护状态
    public static int maxScoreSightseeingPair2(int[] A){
        int max = 0;
        int res = A[0] + 0;
        for (int i=1;i<A.length;i++){
            max = Math.max(max,res+A[i]-i);
            res = Math.max(res,A[i]+i);
        }
        return max;
    }
}
