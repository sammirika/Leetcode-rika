package tanxin;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 ***/
public class eraseOverlapIntervals_435 {

    // 贪心算法学习
    public static int eraseOverlapIntervals(int[][] intervals) {
        // 这里先以end来排序，每次以前一个区间的end 与
        // 后一个区间的start相比如果满足条件count++，这样就求出了不重叠区间个数

        if (intervals.length == 0) {
            return 0;
        }
        // 使用升序的比较器
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果重叠直接跳过即可
            if (intervals[i][0] < end) {
                continue;
            }
            count++;
            end = intervals[i][1];
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(nums));
    }
}
