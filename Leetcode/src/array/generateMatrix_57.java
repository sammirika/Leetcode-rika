package array;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 **/
public class generateMatrix_57 {


    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][]{};
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n * n; i++) {
            queue.add(i);
        }
        int[][] res = new int[n][n];
        int l = 0, r = n - 1;
        int t = 0, d = n - 1;
        while (l <= r && t <= d) {
            for (int i = l; i <= r; i++) {
                res[t][i] = queue.poll();
            }
            t++;
            for (int i = t; i <= d; i++) {
                res[i][r] = queue.poll();
            }
            r--;
            for (int i = r; i >= l && t <= d; i--) {
                res[d][i] = queue.poll();
            }
            d--;
            for (int i = d; i >= t && l <= r; i--) {
                res[i][l] = queue.poll();
            }
            l++;
        }
        return res;
    }
}
