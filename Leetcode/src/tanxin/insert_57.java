package tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 ***/
public class insert_57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        // 将这个新的区间加入数组，再贪心求区间
        int len = intervals.length;
        int[] A = new int[len + 1];
        int[] B = new int[len + 1];
        int index = 0;
        for (int[] interval : intervals) {
            A[index] = interval[0];
            B[index] = interval[1];
            index++;
        }
        A[index] = newInterval[0];
        B[index] = newInterval[1];
        Arrays.sort(A);
        Arrays.sort(B);
        // 贪心合并区间
        List<int[]> res = new ArrayList<>();
        for (int i = 0, j = 0; i <= len; i++) {
            if (i == len || A[i + 1] > B[i]) {
                res.add(new int[]{A[j], B[i]});
                j = i + 1;
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] res = insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        for (int[] array : res) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println(" ");
        }
    }
}
