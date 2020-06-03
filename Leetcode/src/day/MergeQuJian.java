package day;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * ****/



public class MergeQuJian {


    public int[][] merge(int[][] intervals) {
        int[] A = new int[intervals.length];
        int[] B = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            A[i] = intervals[i][0];
            B[i] = intervals[i][1];
        }
        Arrays.sort(A);
        Arrays.sort(B);
        List<int[]> list = new ArrayList<>();
        //j记录起点，i记录对应的区间变化
        for(int i=0,j=0;i<intervals.length;i++){
            if(i==intervals.length-1 || A[i+1]>B[i]){
                list.add(new int[]{A[j],B[i]});
                j=i+1;
            }
        }
        return list.toArray(new int[0][]);
    }
}
